package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.Automobile;
import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.model.AutomobileForm;
import com.example.practisewithoutsequrity.service.AutomobileService;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
public class Z_Controller_without_Security {

    private final UserService userService;
    private final AutomobileService automobileService;
    private final PasswordEncoder passwordEncode;




    @Autowired
    public Z_Controller_without_Security(UserService userService, AutomobileService automobileService
    , PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.automobileService = automobileService;
        this.passwordEncode = passwordEncoder;
    }
    @PostMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable int id, User userUp) {
        userService.updateUser(id, userUp);

        System.out.println("\n");
        return "redirect:/user/HomePage";
    }
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findByAll();
    }











    @GetMapping("/getAllAutomobile")
    public List<Automobile> getAllAuto() {
        return automobileService.findByAll();
    }

    @PostMapping("/saveAuto")
    public String saveAuto(AutomobileForm form) {
        automobileService.save(form.toAuto());

        return "redirect:/admin/homePage";
    }



}
