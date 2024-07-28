package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        logger.info("POST call");
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
        logger.info("GET call");
        return userService.fetchUserList();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") UUID userId) {
        userService.deleteUserById(userId);
        return "User deleted Successfully";
    }
}
