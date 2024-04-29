//package com.example.practisewithoutsequrity.model;
//
//import com.example.practisewithoutsequrity.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class AuthProvider implements AuthenticationProvider {
//
//    private final CustomUserDetailService cUDS;
//    //private PasswordEncoder passEncode;
//
//    @Autowired
//    AuthProvider(CustomUserDetailService cuds
//                 //PasswordEncoder pasEnc
//    ){
//        this.cUDS=cuds;
//      //  this.passEncode=pasEnc;
//    }
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        //возращет имя
//        String name = authentication.getName();
//
//
//        System.out.println("\ninama =======  " + name);
//
//        //не находит пользователя с этим именем
//        UserDetails personalDetails = cUDS.loadUserByUsername(name);
//
//        String password = authentication.getCredentials().toString();
//
//        System.out.println("\n " + password + "   =======    " + personalDetails.getPassword());
//
//        if(password.equals(personalDetails.getPassword()))
//            throw new BadCredentialsException("Incorrect password");    ////////////  ВВЕСТИ НЕЗАШИФРОВАННЫЙ ПАРОЛЬ, КОТОРЫЙ В БД Е ЗАШИФРОВАН
//
//        System.out.println("\nisssssssssssss  ");
//
//        return new UsernamePasswordAuthenticationToken(personalDetails, password, Collections.emptyList());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
