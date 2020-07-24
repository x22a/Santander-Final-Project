package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.model.User;
import com.ironhack.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserControllerImpl {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers(){
        return userService.findAll();
    }
}
