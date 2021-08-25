package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.User;
import com.testOTS.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long userId) {

        User user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User Id not found"+ userId);
        }

        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        user.setId(0);

        userService.save(user);

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.save(user);

        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable long userId) {

        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " +userId);
        }

        userService.deleteById(userId);

        return "Deleted user's id - " + userId;
    }
    
    @PostMapping("/users/auth")
    public User authenticateUser(@RequestBody AuthInfo authInfo){

        User user = userService.findByUsernameAndPassword(authInfo.getUsername(), authInfo.getPassword());

        return user;
    }
}
