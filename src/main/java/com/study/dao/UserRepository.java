package com.study.dao;


import com.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAll();
    public User getById(Long id);
    public User findByName(String name);
}
