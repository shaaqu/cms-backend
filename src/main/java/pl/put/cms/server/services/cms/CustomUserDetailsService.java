package pl.put.cms.server.services.cms;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.put.cms.server.entities.cms.Administrator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CustomUserDetailsService extends UserDetailsService {

    void refreshTokens(String authorizationHeader, HttpServletRequest request, HttpServletResponse response)
            throws IOException;

    Administrator getAuthorizedUser();

}
