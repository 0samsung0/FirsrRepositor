package com.example.practisewithoutsequrity.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public String HomePageAdmin(HttpServletRequest https, Model model){

        model.addAttribute(https.getParameter("email"), "email");
        model.addAttribute(https.getParameter("login"), "login");
        model.addAttribute(https.getParameter("password"), "password");

        return "user/userHome";
    }
}
