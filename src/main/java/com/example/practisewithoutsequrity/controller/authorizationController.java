package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorization")
public class authorizationController {

    @RequestMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){

    }

}
