package com.study.controller;

import com.study.model.Sex;
import com.study.model.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUser(
            @RequestParam(required = false) Sex sex
            ,Pageable pageable
    ) {
        if(pageable != null) {
            if(sex != null) {
                return userService.getUsers(sex, pageable).getContent();
            } else{
                return userService.getUsers(pageable).getContent();
            }
        } else {
            if (sex != null) {
                return userService.getUsers(sex);
            } else {
                return userService.getUsers();
            }
        }
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value="", consumes="application/json")
    public String createUser(@RequestBody User user) {
        return userService.saveNewUser(user) ? "ok" : "failure";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Long userId
                             , @RequestBody User user) {
        user.setId(userId);
        return userService.updateUser(user) ? "ok" : "failure";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        return userService.removeUser(userId) ? "ok" : "failure";
    }

}
