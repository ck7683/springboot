package com.study.controller;

import com.study.model.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
    @PostMapping("/{userId}")
    public User createUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

}
