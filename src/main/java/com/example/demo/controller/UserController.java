package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;


import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") UUID userId) {
        userService.deleteUserById(userId);
        return "User deleted Successfully";
    }
}
