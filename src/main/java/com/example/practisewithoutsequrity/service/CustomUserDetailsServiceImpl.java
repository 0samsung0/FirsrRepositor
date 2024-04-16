package com.example.practisewithoutsequrity.service;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{
    private final UserRepo userRepo;
    private User user;

    private UserDetails buildUserDetails(User user){
        System.out.println("\n11111111111111111111\n");
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    @Autowired
    public CustomUserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
            this.user = userRepo.findByLogin(login);

            return (UserDetails) user;

    }


    @Override
    public UserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(login);
        if (user != null) {

            UserDetails userDetailss = buildUserDetails(user);
            System.out.println("\n2222222222222222222222\n");

            return userDetailss;
        }
        throw new UsernameNotFoundException("User " + login + " not found");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(null!=user.getRole() && !user.getRole().isEmpty()){
          return Arrays
                    .stream(user.getRole().split(","))
                    .map(role->new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getLogin(){
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired(){
        return false;
    }
}
