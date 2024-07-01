package com.example.UniConnect.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.UniConnect.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
