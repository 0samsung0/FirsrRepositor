//package com.example.practisewithoutsequrity.controller;
//
//import com.example.practisewithoutsequrity.model.CustomUserDetails;
//import com.example.practisewithoutsequrity.service.CustomUserDetailService;
//import com.example.practisewithoutsequrity.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class authorizationController {
//
//
//
//    CustomUserDetailService customUserDetailService;
//    private final PasswordEncoder passwordEncode;
//    UserService uS;
//    @Autowired
//    authorizationController(PasswordEncoder passEncoder,
//                            UserService uS,
//                            CustomUserDetailService cusd){
//
//        this.passwordEncode=passEncoder;
//        this.uS=uS;
//        this.customUserDetailService=cusd;
//    }
//
//    @PostMapping("/FirstLogin")
//    public String authorization(@RequestParam(value = "username") String login,
//                                @RequestParam(value = "password") String password) {
//
//        try{
//            UserDetails userDetails = customUserDetailService.loadUserByUsername(login);
//            if(userDetails instanceof CustomUserDetails){
//                CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;  //// попробовать в 38 строке  СustomUserDetails userDetails = customUserDetailService.loadUserByUsername(login);
//                if(customUserDetails.getUser().getRole().equals("ADMIN")){
//                    return "redirect:/admin/homePage";
//                }else return "redirect:/user/HomePage";
//            }
//        }catch (UsernameNotFoundException e){
//            //redirectAttributes.addFlashAttribute("error", "Invalid username or password");
//            System.out.println("\nnot found");
//            return "redirect:/login";
//        }
//
//
//
//
//
//
//
////        User user = uS.findByLogin(login);
////
////        if(passwordEncode.matches(password,user.getPassword())){
////            if(user.getRole().equals("ADMIN")) {
////                System.out.println("ROLE IS ADMIN !!!!!!!!!!!!!! \n");
////                return "redirect:/admin/homePage";
////            }
////            System.out.println("ROLE IS USER !!!!!!!!!!!!!! \n");
////            return "redirect:/user/HomePage";
////
////        }
////
////        System.out.println("\nencodePassword = "+passwordEncode.encode(password) +
////                "\n" + "user.Password = " + user.getPassword() + "\n");
////
////        return "redirect:/LoginPage";
//
//        return "redirect:/LoginPage";
//    }
//}
//
