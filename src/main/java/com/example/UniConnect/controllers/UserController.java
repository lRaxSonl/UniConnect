package com.example.UniConnect.controllers;

import com.example.UniConnect.models.User;
import com.example.UniConnect.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;


    @GetMapping("/registration")
    public String viewRegistrationPage() {
        if (userService.isAuthorized()){
            return "redirect:/";
        } else {
            return "signup";
        }
    }

    @PostMapping("/registration-now")
    public String registrationProcess(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        if (userService.isAuthorized()) {
            return "redirect:/";
        }else {
            return "login";
        }
    }

    @PostMapping("/login-now")
    public String loginNow(User user){
        return "redirect:/";
    }


}
