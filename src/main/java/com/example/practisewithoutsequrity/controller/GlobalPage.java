package com.example.practisewithoutsequrity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/GlobalPage")
public class GlobalPage {


    @GetMapping
    public String regPage(){
        return "GlobalHome";
    }



}






