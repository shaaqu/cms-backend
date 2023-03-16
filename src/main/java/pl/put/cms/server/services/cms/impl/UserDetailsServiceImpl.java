package pl.put.cms.server.services.cms.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.put.cms.server.configuration.JwtTokenProvider;
import pl.put.cms.server.entities.cms.Administrator;
import pl.put.cms.server.repositories.cms.AdministratorRepository;
import pl.put.cms.server.services.cms.CustomUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements CustomUserDetailsService {

    private final AdministratorRepository administratorRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserDetailsServiceImpl(AdministratorRepository administratorRepository, JwtTokenProvider jwtTokenProvider) {
        this.administratorRepository = administratorRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<Administrator> user = administratorRepository.findByLogin(login);
        if (user.isEmpty()) {
            throw new NullPointerException("Cannot find user");
        } else {
            log.info("Found user: {}", user.get().getLogin());
            return user.get();
        }
    }

    @Override
    public void refreshTokens(String authorizationHeader, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String login = jwtTokenProvider.getUserLoginFromJWT(authorizationHeader.substring("Bearer ".length()));
        Optional<Administrator> user = administratorRepository.findByLogin(login);
        if (user.isEmpty()) {
            throw new NullPointerException("Cannot find user");
        } else {
            String accessToken = jwtTokenProvider.generateAccessToken(request, user.get());
            String refreshToken = jwtTokenProvider.generateRefreshToken(request, user.get());
            jwtTokenProvider.setResponseWithTokens(response, accessToken, refreshToken);
        }
    }

    @Override
    public Administrator getAuthorizedUser() {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Authorized email: {}", login);
        Optional<Administrator> administrator = administratorRepository.findByLogin(login);
        if (administrator.isEmpty()) {
            log.error("Authorized user not found!");
            throw new NullPointerException("Cannot find user");
        } else {
            return administrator.get();
        }
    }

}
