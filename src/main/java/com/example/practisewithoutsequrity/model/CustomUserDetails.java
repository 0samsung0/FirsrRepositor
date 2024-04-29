package com.example.practisewithoutsequrity.model;

import com.example.practisewithoutsequrity.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;


public class CustomUserDetails implements UserDetails {

    @Getter
    private User user;

    private PasswordEncoder passwordEncoder;

    public CustomUserDetails(User user ) {
        this.user = user;
    }

    public CustomUserDetails(){}


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("\n user ROLE ===  "+user.getRole());
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
