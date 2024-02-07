package com.example.practisewithoutsequrity.controller;


import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Registration", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ModelAndView addUser(User user){

        ModelAndView MAN = new ModelAndView();

        System.out.println(user.toString() + "111111111111");

        if(userService.findByEmail(user.getEmail()) == null){
            MAN.setViewName("Login");
            System.out.println(user.toString() + "2222222222");
            userService.SaveUser(user);
            System.out.println(user.toString() + "333333333333");
        }else{
            MAN.setViewName("Registration");
        }
        System.out.println(user.toString() + "444444444");
        return MAN;
    }

    @GetMapping("/Registration")
    public String regPage(){
        return "Registration";
    }



}