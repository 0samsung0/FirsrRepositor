//package com.example.practisewithoutsequrity.config;
//
//import com.example.practisewithoutsequrity.service.CustomUserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.security.AuthProvider;
//
//@Configuration
//public class AuthProviderConfig {
//
//    @Bean
//    public AuthProvider authProvider(CustomUserDetailService customUserDetailService,
//                                     PasswordEncoder passwordEncoder){
//
//        return new AuthProvider(customUserDetailService, passwordEncoder);
//
//    }
//}
