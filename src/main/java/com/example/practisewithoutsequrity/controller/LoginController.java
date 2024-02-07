package com.example.practisewithoutsequrity.controller;//package com.example.practisewithoutsequrity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/LoginPage")
    public String showHome(){
        return "Login";
    }

}