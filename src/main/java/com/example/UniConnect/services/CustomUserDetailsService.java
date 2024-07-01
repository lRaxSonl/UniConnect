package com.example.UniConnect.services;

import com.example.UniConnect.interfaces.UserRepository;
import com.example.UniConnect.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.UniConnect.models.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        user.setPassword(user.getPassword().trim());
        System.out.println(user.getUsername() + ' ' + ' ' + user.getPassword());
        return CustomUserDetails.build(user);
    }
}
