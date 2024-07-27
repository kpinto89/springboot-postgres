package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
        User saveUser(User user);
        List<User> fetchUserList();
        void deleteUserById(UUID userId);
}
