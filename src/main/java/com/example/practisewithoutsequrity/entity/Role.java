package com.example.practisewithoutsequrity.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN,
    SYSADMIN,
    USER;

    @Override
    public String getAuthority(){return name();}


}
