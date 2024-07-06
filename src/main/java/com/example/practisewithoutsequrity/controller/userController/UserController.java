package com.example.practisewithoutsequrity.controller.userController;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.repository.UserRepo;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    UserRepo userRepo;
    UserService userService;

    @Autowired
    UserController(UserService us, UserRepo ur){
        this.userService = us;
        this.userRepo = ur;
    }

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public String HomePageAdmin(Model model) {
        return "user/userHome";

    }

    @GetMapping(path = "/userUpdated")
    public String UpdateUser( Model model) {


        List<User> users = userRepo.findAll();
        User loadUser = new User();

        String userName="";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userName = ((UserDetails) principal).getUsername();
        for(User u : users){
            if(u.getUsername().equals(userName)){
                loadUser.setPhone(u.getPhone());
                loadUser.setEmail(u.getEmail());
                loadUser.setPosition(u.getPosition());
                loadUser.setUsername(u.getUsername());
                loadUser.setId(u.getId());

                break;
            }
        }

        System.out.println( userName+ "---------------------------------------------------------------");

        //Optional<User> userOptional = userRepo.findByUsername(userName);
      //  Hibernate.initialize(userOptional.get().getDrive());

        //System.out.println(userOptional);
        //User user = userOptional.get();

        model.addAttribute("user", loadUser);
        //int id = user.getId();
        model.addAttribute("id", loadUser.getId());

        //System.out.println(" \n FULLL is useeeeeeer === " + user.toString());

        return "user/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(
            @RequestParam("id") int id, User userUp) {
        System.out.println("\nTHIS IS THE UPDATED USER" + userUp.getId() + "\n\n AND ======  "
                + userUp.toString() + "\n\n");
        userService.updateUser( id,
                //userUp.getId(),
                userUp);

        System.out.println("\nTHIS IS THE UPDATED USER" + userUp.toString() + "\n\n");
        return "redirect:/user/HomePage";
    }

    @RequestMapping(value = "/getTask")
    public String getTask(){
        return "user/getTask";
    }

    @RequestMapping(value = "/showListDrivee", method = RequestMethod.GET)
    public String showDriveUser(Model model){
        //List<Drive> drives = driveRepo.findAll();
        //model.addAttribute("drives", drives);
        return "/user/showListDrives";
    }

}
