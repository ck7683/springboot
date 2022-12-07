package com.study.dao;


import com.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAll();

    public List<User> findByIsDelete(boolean isDelete);
    public Optional<User> findById(Long id);
    public User findByName(String name);
}
