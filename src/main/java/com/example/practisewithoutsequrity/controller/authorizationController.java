package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.CustomUserDetailsServiceImpl;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class authorizationController {


    private final CustomUserDetailsServiceImpl uDService;
    private final PasswordEncoder passwordEncode;
    UserService uS;
    @Autowired
    authorizationController(CustomUserDetailsServiceImpl us,
                            PasswordEncoder passEncoder,
                            UserService uS){
        this.uDService=us;
        this.passwordEncode=passEncoder;
        this.uS=uS;
    }

    @PostMapping("/FirstLogin")
    public String authorization(@RequestParam(value = "login", required = true) String login,
                                @RequestParam(value = "password", required = false) String password) {



        User user = uS.findByLogin(login);
        System.out.println("\n\n +++++++++" + new SimpleGrantedAuthority(user.getRole()));
        System.out.println("-----------------------------\n");

        UserDetails userDetails;
        userDetails = uDService.loadUserByLogin(login);
        System.out.println(user.toString() + "\n----------------------------- \n"+ "passwordNotEncode = "+
                password + "\n"+
                passwordEncode.encode(password)+"\n");

        System.out.println("\nIS PASSWORDS IS ===== " + passwordEncode.matches(password,user.getPassword()));

        if(passwordEncode.matches(password,user.getPassword())){
            if(user.getRole().equals("ADMIN")) {
                System.out.println("ROLE IS ADMIN !!!!!!!!!!!!!! \n");
                return "redirect:/admin/homePage";
            }
            System.out.println("ROLE IS USER !!!!!!!!!!!!!! \n");
            return "redirect:/user/HomePage";

        }

        System.out.println("\nencodePassword = "+passwordEncode.encode(password) +
                "\n" + "user.Password = " + user.getPassword() + "\n");

        return "redirect:/LoginPage";

    }
}

