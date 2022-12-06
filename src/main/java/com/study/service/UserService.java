package com.study.service;


import com.study.dao.UserRepository;
import com.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
