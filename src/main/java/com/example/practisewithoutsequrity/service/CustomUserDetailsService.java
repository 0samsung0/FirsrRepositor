package com.example.practisewithoutsequrity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface CustomUserDetailsService extends UserDetailsService {
    UserDetails loadUserByLogin(String login);

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getLogin();

    boolean isAccountNonExpired();
}