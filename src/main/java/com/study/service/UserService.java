package com.study.service;


import com.study.dao.UserRepository;
import com.study.model.Sex;
import com.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findByIsDelete(false);
    }

    public List<User> getUsers(Sex sex) {
        return userRepository.findByIsDeleteAndSex(false, sex);
    }
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findByIsDelete(false, pageable);
    }

    public Page<User> getUsers(Sex sex, Pageable pageable) {
        return userRepository.findByIsDeleteAndSex(false, sex, pageable);
    }

    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public boolean saveNewUser(User user) {
        try{
            user.setId(null);
            user.setIsDelete(false);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean updateUser(User user) {
        try{
            user.setIsDelete(false);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean removeUser(Long id) {
        try {
            User user = userRepository.getById(id);
            user.setIsDelete(true);
            userRepository.save(user);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
