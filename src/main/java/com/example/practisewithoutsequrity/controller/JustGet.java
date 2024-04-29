package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AllUsers")
public class JustGet {

    private UserService userService;

    JustGet(UserService userS){
        userService = userS;
    }

    //@ResponseBody
    @GetMapping
    public String getAll(){
        System.out.println("\n isssssssssssssssss");
        return "redirect:/admin/homePage";
        //return userService.findByAll();
    }

}
