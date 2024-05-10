package com.example.practisewithoutsequrity.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/homePage");
                return;
            } else if (authority.getAuthority().equals("ROLE_USER")) {
                System.out.println("\nthis is user\n\n");
                response.sendRedirect("/user/HomePage");
                return;
            }
        }
        // Если ни одна из ролей не совпадает, выполняйте перенаправление по умолчанию
        response.sendRedirect("/LoginPage");
    }
}