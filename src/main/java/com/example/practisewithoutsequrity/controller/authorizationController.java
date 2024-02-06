package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/authorization")
public class authorizationController {

    @Autowired
    private UserService service;
    @RequestMapping(value = "/register", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ModelAndView getUserById( User user) {


        User usser = service.findByEmail(user.getEmail());
        ModelAndView modelAndView = new ModelAndView();
        //System.out.println("Usser is - " + usser.toString());

        List<User> lst= service.findByAll();
        System.out.println(lst.toString());

        if (usser != null) {
            modelAndView.addObject("user", usser);
            modelAndView.setViewName("modelView");
        } else {
            modelAndView.setViewName("errorView");
        }

        return modelAndView;
    }

}
