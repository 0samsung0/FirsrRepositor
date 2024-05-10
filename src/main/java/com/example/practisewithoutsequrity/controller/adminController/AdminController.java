package com.example.practisewithoutsequrity.controller.adminController;


import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.repository.UserRepo;
import com.example.practisewithoutsequrity.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@NoArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;
    UserRepo userRepo;

    @Autowired
    AdminController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    };

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePageAdmin(Model model){
        System.out.println("111111111111");
        return "admin/adminHome";
    }

    @GetMapping(path = "/adminUpdated")
    public String UpdateUser(Model model) {

        String userName="";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userName = ((UserDetails) principal).getUsername();

        System.out.println(userName);

        User user = userRepo.findByUsername(userName).get();
        model.addAttribute("user", user);
        int id = user.getId();
        model.addAttribute("id", id);

        System.out.println(" \n FULLL is useeeeeeer === " + user.toString());

        return "admin/adminUpdate";
    }

    @PostMapping("/adminUpdate")
    public String updateAdmin(
            @RequestParam("id") int id, User userUp) {
        System.out.println("\nTHIS IS THE UPDATED ADMIN" + userUp.getId() + "\n\n AND ======  "
                + userUp.toString() + "\n\n");
        userService.updateUser( id,
                //userUp.getId(),
                userUp);

        System.out.println("\nTHIS IS THE UPDATED ADMIN" + userUp.toString() + "\n\n");
        return "redirect:/admin/homePage";
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
