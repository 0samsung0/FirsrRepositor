package com.example.practisewithoutsequrity.controller.adminController;


import com.example.practisewithoutsequrity.entity.*;
import com.example.practisewithoutsequrity.model.AutomobileForm;
import com.example.practisewithoutsequrity.model.DriveForm;
import com.example.practisewithoutsequrity.model.LocationForm;
import com.example.practisewithoutsequrity.model.TaskForm;
import com.example.practisewithoutsequrity.repository.*;
import com.example.practisewithoutsequrity.service.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    EntityManager entityManager;
    DriveRepo driveRepo;
    UserService userService;
    UserRepo userRepo;
    AutomobileRepo automobileRepo;
    TaskRepo taskRepo;
    LocationRepo locationRepos;
    AutomobileService automobileService;
    TaskService taskService;
    LocationService locationService;
    DriveService driveService;

    @Autowired
    AdminController(UserRepo userRepo,
                    UserService userService,
                    AutomobileRepo autRepo,
                    TaskRepo taskRepo,
                    LocationRepo locRepo,
                    DriveRepo driveRepo,
                    AutomobileService autoServise,
                    TaskService taskService,
                    LocationService locationService,
                    DriveService driveService) {
        this.userRepo = userRepo;
        this.userService = userService;
        this.automobileRepo = autRepo;
        this.taskRepo = taskRepo;
        this.locationRepos = locRepo;
        this.driveRepo = driveRepo;
        this.automobileService = autoServise;
        this.taskService = taskService;
        this.locationService = locationService;
        this.driveService = driveService;
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


    @RequestMapping(value = "/businessRide", method = RequestMethod.GET)
    public String wordDrive(){
        return "admin/wayDrive";
    }




    @RequestMapping(value = "/createDrive" , method = RequestMethod.GET)
    public String createDrive(Model model) {

        List<Automobile> automobiles = automobileRepo.findAll();
        List<User> users = userRepo.findAll();
        List<Task> tasks = taskRepo.findAll();
        List<Location> locations = locationRepos.findAll();

        Drive drive = new Drive();

        drive.setStatus("free");

        model.addAttribute("automobiles", automobiles);
        model.addAttribute("users", users);
        model.addAttribute("tasks", tasks);
        model.addAttribute("locations", locations);
        model.addAttribute("drive", drive);


        return "/admin/addDrive";
    }

//    @Transactional
    @RequestMapping(value = "/saveItDrive", method = RequestMethod.POST)
    public String saveDrive(@ModelAttribute("drive") String title,
                            @RequestParam("automobile_id") Integer autoId,
                            @RequestParam("task_id") Integer taskId,
                            @RequestParam("user_id") Integer userId,
                            @RequestParam("location_id") Integer locationId) {

//        System.out.println("\nauto_id =" + autoId + "\ntaskId =" + taskId
//                + "\nlocat ="+locationId +"\nrepoFoundLocation ="+userRepo.findById(userId).get().toString());
//
//
          Drive drive = new Drive("Locked", title);
          drive.setLocation(locationRepos.findById(locationId).get());
          System.out.println("\nonly response true\n");
//
        drive.getUsers().add(userRepo.findById(userId).get());
        System.out.println("\nonly response true\n");
        drive.getTask().add(taskRepo.findById(taskId).get());
        System.out.println("\nonly response true\n");
        drive.getAuto().add(automobileRepo.findById(autoId).get());
       // System.out.println("\nadd true\n"+ drive.getAuto().toString() + "\n\n");

        driveRepo.save(drive);
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! save true !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        List<Drive>  driveList = driveRepo.findAll();


        for(Drive d : driveList){
            if(drive.getTitle() == d.getTitle()){
                User user = userRepo.findById(userId).get();
                user.setDrive(drive);
                Automobile automobile = automobileRepo.findById(autoId).get();
                automobile.setDrive(drive);
                Task task = taskRepo.findById(taskId).get();
                task.setDrive(drive);
                userRepo.save(user);
                taskRepo.save(task);
                automobileRepo.save(automobile);
            }
        }

        return "admin/adminHome";
    }






    @PostMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable int id, User userUp) {
        userService.updateUser(id, userUp);

        System.out.println("\n");
        return "redirect:/user/HomePage";
    }
    @GetMapping("/getAllUserss")
    @Transactional
    public String getAll(Model model) {

       // List<User> users = userRepo.findAll();
       // model.addAttribute("users", users);


        return "admin/showUsers";
    }






    @GetMapping("/getAllAutomobile")
    public List<Automobile> getAllAuto() {
        return automobileService.findByAll();}
    @PostMapping("/saveAuto")
    public String saveAuto(AutomobileForm form) {
        automobileService.save(form.toAuto());
        return "redirect:/admin/homePage";
    }




    @GetMapping("/getAllTask")
    public List<Task> getAllTask() {
        return taskService.findByAll();}
    @PostMapping("/saveTask")
    public String saveTask(TaskForm form) {
        taskService.saveTask(form.toTask());
        return "redirect:/admin/homePage";
    }




    @GetMapping("/getAllLocation")
    public List<Location> getAllLocation() {
        return locationService.findByAll();}
    @PostMapping("/saveLocation")
    public String saveTask(LocationForm form) {
        locationService.saveLocation(form.toLocation());
        return "redirect:/admin/homePage";
    }




    @GetMapping("/getAllDrive")
    public String getAllDrive() {

        return "admin/showDrive";
    }

    @PostMapping("/saveDrive")
    public String saveTask(DriveForm form) {
        driveService.saveDrive(form.toDrive());
        return "redirect:/admin/homePage";
    }

    @RequestMapping(value = "/report")
    public String report(){
        return "admin/admin2";
    }

    @RequestMapping(value = "/adminn")
    public String addAutoo(){
        return "/admin/admin1";
    }
    @RequestMapping(value = "/automobiles")
    public String addAuto(){
        return "/admin/addAuto";
    }
    @RequestMapping(value = "/drives")
    public String addDrive(){
        return "/admin/showUsers";
    }
    @RequestMapping(value = "/tasks")
    public String addTasks(){
        return "/admin/addTask";
    }
    @RequestMapping(value = "/locations")
    public String addLocation(){
        return "/admin/addLocation";
    }
}
