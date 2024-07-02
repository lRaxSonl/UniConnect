package com.example.UniConnect.services;


import com.example.UniConnect.config.SecurityConfig;

import com.example.UniConnect.enums.Roles;
import com.example.UniConnect.interfaces.UserRepository;

import com.example.UniConnect.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService{
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;

    public boolean saveUser(User user) {
        try {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                return false;
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);

            log.info("Saving new user: {}", user);
            return true;
        }catch (IllegalAccessError e) {
            return false;
        }
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User findByUsernameIfExists(String username) {
        User user = userRepository.findByUsername(username);
        if (!user.equals(null)) {
            return user;
        }
        return null;
    }

    public User getCurrentUser() {
        try {
            return userRepository.findByUsername(securityConfig.getCurrentUsername());
        }catch (NullPointerException e) {
            log.info("Current user has not found");
        }
        return null;
    }

    public boolean isAuthorized(){
        try {
            if (getCurrentUser().equals(null)) {
                return false;
            } else {
                return true;
            }
        }catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isAdmin(User user) {
        try {
            if (findUserById(user.getId()).getRole().equals(Roles.ADMIN)) {
                return true;
            } else {
                return false;
            }
        }catch (NullPointerException e) {
            return false;
        }
    }
}

