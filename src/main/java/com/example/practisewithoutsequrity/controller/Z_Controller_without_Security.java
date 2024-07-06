package com.example.practisewithoutsequrity.controller;

import com.example.practisewithoutsequrity.entity.*;
import com.example.practisewithoutsequrity.model.AutomobileForm;
import com.example.practisewithoutsequrity.model.DriveForm;
import com.example.practisewithoutsequrity.model.LocationForm;
import com.example.practisewithoutsequrity.model.TaskForm;
import com.example.practisewithoutsequrity.repository.*;
import com.example.practisewithoutsequrity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//@RestController
@RequestMapping("/test")
@Controller
@ResponseBody
public class Z_Controller_without_Security {

    private final UserService userService;
    private final AutomobileService automobileService;
    private final PasswordEncoder passwordEncode;
    private final LocationService locationService;
    private final TaskService taskService;
    private final DriveService driveService;
    private final DriveRepo driveRepo;
    private final AutomobileRepo automobileRepo;
    private final UserRepo userRepo;
    private final TaskRepo taskRepo;
    private final LocationRepo locationRepos;


    @Autowired
    public Z_Controller_without_Security(UserService userService,
                                         AutomobileService automobileService,
                                         PasswordEncoder passwordEncoder,
                                         LocationService locationService,
                                         TaskService taskService,
                                         DriveService driveService,
                                         DriveRepo driveRepo,
                                         AutomobileRepo automobileRepo,
                                         UserRepo userRepo,
                                         TaskRepo taskRepo,
                                         LocationRepo locationRepo) {
        this.userService = userService;
        this.automobileService = automobileService;
        this.passwordEncode = passwordEncoder;
        this.locationService = locationService;
        this.taskService = taskService;
        this.driveService = driveService;
        this.driveRepo = driveRepo;
        this.automobileRepo = automobileRepo;
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
        this.locationRepos = locationRepo;
    }
    @PostMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable int id, User userUp) {
        userService.updateUser(id, userUp);

        System.out.println("\n");
        return "redirect:/user/HomePage";
    }
    @GetMapping("/getAllUsers")
    @Transactional
    public List<User> getAll() {
        return userRepo.findAll();
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
    public List<Drive> getAllDrive() {
        System.out.println(driveRepo.findAll());
        return driveService.findByAll();}
    @PostMapping("/saveDrive")
    public String saveTask(DriveForm form) {
        driveService.saveDrive(form.toDrive());
        return "redirect:/admin/homePage";
    }


    @RequestMapping(value = "/showListDriveUser", method = RequestMethod.GET)
    public String showDrive(Model model){
        List<Drive> drives = driveRepo.findAll();
        model.addAttribute("drives", drives);
        return "/admin/showListDriver";
    }
    @RequestMapping(value = "/showListDrivee", method = RequestMethod.GET)
    public String showDriveUser(Model model){
        //List<Drive> drives = driveRepo.findAll();
        //model.addAttribute("drives", drives);
        return "/user/showListDrives";
    }



@RequestMapping(value = "/watchDriveUser", method = RequestMethod.GET)
@Transactional
public String watchDriveUser(@RequestParam("id_drive") int id, Model model) {
    Optional<Drive> optionalDrive = driveRepo.findById(id);
    if (optionalDrive.isPresent()) {
        Drive drive = optionalDrive.get();

        model.addAttribute("tasks", drive.getTask());
        model.addAttribute("autos", drive.getAuto());
        model.addAttribute("location", drive.getLocation());

        System.out.println("\n\n TTTTTTTTTTTTTTTTTT ====================== " + drive.getTask() + "      " + drive + "\n\n");
    } else {
        System.out.println("Drive with id " + id + " not found.");
         // или другой шаблон ошибки
    }

    return "/user/showDrive";
}
    @GetMapping("/watchDrive")
    public String watchDrive(@RequestParam("id_drive") int id, Model model){

        List<Automobile> autos = automobileRepo.findAll();
        List<User> users = userRepo.findAll();
        List<Task> tasks = taskRepo.findAll();
        Drive drive = driveRepo.findById(id).get();

        model.addAttribute("users", users);
        model.addAttribute("tasks", tasks);
        model.addAttribute("autos", autos);
        model.addAttribute("drive", drive);

        return "/admin/addInformationToWatch";
    }
    @PostMapping("/saveToDrive")
    public void saveCarToDrive(@RequestParam("selectedDrive") int driver,
                               @RequestParam("selectedUser") int selectedUsers,
                               @RequestParam("selectedTask") int selectedTasks,
                               @ModelAttribute("") LocationForm locForm,
                               @RequestParam("selectedAuto") int selectedCar) {

        System.out.println("\n driveId = " + driver
                + " userId = " + selectedUsers
                + " taskId = " + selectedTasks
                + " carId = " + selectedCar
                + "LocationForm = " + locForm.toLocation() + "\n\n");


        Drive drive = driveRepo.findById(driver).get();
        User user = userRepo.findById(selectedUsers).get();
        Task task = taskRepo.findById(selectedTasks).get();
        //locationService.saveLocation(locForm.toLocation());
        drive.setLocation(locForm.toLocation());
        Automobile auto = automobileRepo.findById(selectedCar).get();

        driveRepo.save(drive);
    }
    @GetMapping("showDrive")
    public String showDrive(@RequestParam("id_drive") int id, Model model){

        Optional<Drive> drive = driveRepo.findById(id);
        Drive drive1 = drive.get();


        List<Automobile> autos = drive1.getAuto();
        List<User> users = drive1.getUsers();
        List<Task> tasks = drive1.getTask();
        Location location = drive1.getLocation();

        model.addAttribute("users", users);
        model.addAttribute("tasks", tasks);
        model.addAttribute("autos", autos);
        model.addAttribute("location", location);

        return "/user/showDrive";

    }
    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);

        return "/admin/showUsers";
    }



    @GetMapping("/showDrives")
    public String showDrives(Model model) {






        return "/admin/showDrive";
    }


    // Other methods for handling requests can be added here
}






