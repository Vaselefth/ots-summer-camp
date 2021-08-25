package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.UserRepository;
import com.testOTS.demo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long theId) {
        Optional<User> result = userRepository.findById(theId);

        User user = null;

        if(result.isPresent()) {
            user = result.get();
        }
        else {
            throw new RuntimeException("Did not found that userId");
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long theId) {
        userRepository.deleteById(theId);
    }
    
    @Override
    public User findByUsernameAndPassword(String username, String password) {

        User result = userRepository.findByUsernameAndPassword(username, password);

        if(result == null){
            throw new RuntimeException("Did not find that user");
        }

        return result;
    }
}
