package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/AllUsers")
public class JustGet {

    private UserService userService;

    JustGet(UserService userS){
        userService = userS;
    }

    @ResponseBody
    @GetMapping
    public List<User> getAll(){
        return userService.findByAll();
    }

}
