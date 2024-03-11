package com.example.practisewithoutsequrity.controller;


import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @GetMapping("/Registration")
    public String regPage(){
        return "Registration";
    }
    @RequestMapping(value = "/Registration", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String phone,
                                @RequestParam String email,
                                @RequestParam String position,
                                @RequestParam String password,
                                @RequestParam String login){

        ModelAndView MAN = new ModelAndView();
        User user = new User();

        if(userService.findByLogin(user.getLogin()) == null ){
            MAN.setViewName("Login");


            user.setName(name);
            user.setPhone(phone);
            user.setEmail(email);
            user.setPosition(position);
            user.setPassword(password);
            user.setLogin(login);
            user.isUser();

            userService.SaveUser(user);
        }else{
            MAN.setViewName("Registration");
        }

        return MAN;
    }





}