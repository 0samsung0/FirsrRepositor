package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class authorizationController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/emp-adm/work", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ModelAndView getUserById(User user) {

        User usser = service.findByEmail(user.getEmail());
        ModelAndView modelAndView = new ModelAndView();



        if (usser != null) {


            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);




            if(authenticationToken.isAuthenticated()){

                SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println(usser.toString());
                if(usser.getRole() == "ADMIN"){


                    ModelMap mm = new ModelMap();

                    mm.addAttribute("login", user.getLogin());
                    mm.addAttribute("password", user.getPassword());
                    mm.addAttribute("email", user.getEmail());

                    System.out.println("ROLE IS ADMIN !!!!!!!!!!!!!!");

                    return new ModelAndView("redirect:/admin/homePage", mm);

                }else{


                    ModelMap mm = new ModelMap();

                    mm.addAttribute("login", user.getLogin());
                    mm.addAttribute("password", user.getPassword());
                    mm.addAttribute("email", user.getEmail());

                    System.out.println("ROLE IS NOT ADMIN !!!!!!!!!!!!!!");

                    return new ModelAndView("redirect:/user/HomePage", mm);
                }

            }

        } else {
            return modelAndView;
        }
        return modelAndView;
    }


}

