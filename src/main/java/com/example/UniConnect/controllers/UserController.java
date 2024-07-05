package com.example.UniConnect.controllers;

import com.example.UniConnect.models.User;
import com.example.UniConnect.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;


    @GetMapping("/registration")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("title", "Registration");
        if (userService.isAuthorized()){
            return "redirect:/";
        } else {
            return "signup";
        }
    }

    @PostMapping("/auth/registration-now")
    public String registrationProcess(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model){
        model.addAttribute("title", "Login");
        if (userService.isAuthorized()) {
            return "redirect:/";
        }else {
            return "login";
        }
    }

    @PostMapping("/auth/login-now")
    public String loginNow(User user){
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }


}
