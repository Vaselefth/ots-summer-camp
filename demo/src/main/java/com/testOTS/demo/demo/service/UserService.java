package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(long theId);

    public void save(User user);

    public void deleteById(long theId);
    
    User findByUsernameAndPassword(String username, String password);
}
