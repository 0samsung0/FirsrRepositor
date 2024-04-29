package com.example.practisewithoutsequrity.service;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.model.CustomUserDetails;
import com.example.practisewithoutsequrity.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    UserRepo userRepo;
    CustomUserDetailService(UserRepo uR){
        this.userRepo=uR;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        User userf = user.get();

        System.out.println("\n................. name = " + userf.getUsername()+ " ..........password = " + userf.getPassword());
        if(user.isEmpty())
            throw new UsernameNotFoundException("User not found");

        //System.out.println("this.user in customUserDetailService === " + user.get);

        System.out.println("\n return in CustomUserDetailService" );

        return new CustomUserDetails(user.get());
    }
}
