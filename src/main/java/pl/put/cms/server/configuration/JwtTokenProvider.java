package pl.put.cms.server.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import pl.put.cms.server.entities.cms.Administrator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component @Slf4j
public class JwtTokenProvider {

    private final Environment environment;

    @Autowired
    public JwtTokenProvider(Environment environment) {
        this.environment = environment;
    }

    public String generateAccessToken(HttpServletRequest request, Authentication authentication) {
        Administrator user = (Administrator) authentication.getPrincipal();
        return generateJwtToken(request, user, getAccessTokenExpirationDate());
    }

    public String generateAccessToken(HttpServletRequest request, Administrator admin) {
        return generateJwtToken(request, admin, getAccessTokenExpirationDate());
    }

    public String generateRefreshToken(HttpServletRequest request, Authentication authentication) {
        Administrator admin = (Administrator) authentication.getPrincipal();
        return generateJwtToken(request, admin, getRefreshTokenExpirationDate());
    }

    public String generateRefreshToken(HttpServletRequest request, Administrator admin) {
        return generateJwtToken(request, admin, getRefreshTokenExpirationDate());
    }

    private Date getAccessTokenExpirationDate() {
        return new Date(System.currentTimeMillis() + JwtTokenProperties.ACCESS_TOKEN_EXPIRATION_TIME);
    }

    private Date getRefreshTokenExpirationDate() {
        return new Date(System.currentTimeMillis() + JwtTokenProperties.REFRESH_TOKEN_EXPIRATION_TIME);
    }

    private String generateJwtToken(HttpServletRequest request, Administrator admin, Date expireDate) {
        Algorithm algorithm = Algorithm.HMAC256(getSecret().getBytes());
        return JWT.create()
                .withSubject(admin.getLogin())
                .withExpiresAt(expireDate)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", admin.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(algorithm);
    }

    public String getUserLoginFromJWT(String token) {
        return JWT.require(Algorithm.HMAC256(getSecret().getBytes()))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            verifyToken(authToken);
            return true;
        } catch (JWTVerificationException e) {
            log.error(e.getLocalizedMessage());
            log.error("JWT claims string is empty");
        }
        return false;
    }

    private DecodedJWT verifyToken(String token) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(getSecret().getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    private String getSecret() {
        return environment.getProperty("spring.security.jwt.token.secretKey");
    }

    public UsernamePasswordAuthenticationToken authorizeToken(String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer ".length());
        DecodedJWT decodedJWT = verifyToken(token);
        String login = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        return new UsernamePasswordAuthenticationToken(login, null, authorities);
    }

    public void setResponseWithTokens(HttpServletResponse response, String accessToken, String refreshToken)
            throws IOException {
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

}
