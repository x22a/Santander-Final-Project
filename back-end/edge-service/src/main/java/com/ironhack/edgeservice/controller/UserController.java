package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.controller.dto.JwtAuthenticationResponse;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    public User signInUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }
}
