package com.example.practisewithoutsequrity.controller;


import com.example.practisewithoutsequrity.model.RegistrationForm;
import com.example.practisewithoutsequrity.repository.UserRepo;
import com.example.practisewithoutsequrity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Registration")
public class RegistrationController {


    private UserRepo userRepo;
    private PasswordEncoder passwordEncode;
    private UserService userService;

    @Autowired
    RegistrationController(UserRepo userRepos,
                           PasswordEncoder passwEnc,
                           UserService userService ){
        this.userRepo=userRepos;
        this.passwordEncode=passwEnc;
        this.userService=userService;
    }



    @GetMapping
    public String regPage(){
        return "Registration";
    }




    @PostMapping
    public String addUser(RegistrationForm form){
        userService.SaveUser(form.toUser(passwordEncode));

        return "redirect:/LoginPage";
    }








}

