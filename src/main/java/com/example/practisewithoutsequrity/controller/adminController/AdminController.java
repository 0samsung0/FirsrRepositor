package com.example.practisewithoutsequrity.controller.adminController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {



    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePageAdmin(ModelMap model){
        System.out.println("111111111111");
        return "admin/adminHome";
    }







    @RequestMapping(value = "/my-profile", method = RequestMethod.GET)
    public String workWithProfile(ModelMap model){

        return "";
    }

    @RequestMapping(value = "/work-car", method = RequestMethod.GET)
    public String workWithCar(ModelMap model){
        return "";
    }


    @RequestMapping(value = "/work-trips", method = RequestMethod.GET)
    public String workWithRide(ModelMap model){
        return "";
    }

    @RequestMapping(value = "/work-user", method = RequestMethod.GET)
    public String workWithUsers(ModelMap model){
        return "";
    }
}
