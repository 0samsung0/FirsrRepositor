package com.example.practisewithoutsequrity.controller.userController;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    UserService userService;

    @Autowired
    UserController(UserService us){
        this.userService = us;
    }

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public List<User> HomePageAdmin(HttpServletRequest https) {

//        Model model = new Model() {
//        };
//        model.addAttribute(https.getParameter("email"), "email");
//        model.addAttribute(https.getParameter("login"), "login");
//        model.addAttribute(https.getParameter("password"), "password");
//
//        return "user/userHome";
        return userService.findByAll();

    }


}
