package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.controller.dto.JwtAuthenticationResponse;
import com.ironhack.edgeservice.controller.dto.UserLoginRequest;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtAuthenticationResponse loginUser(@RequestBody @Valid UserLoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }



}
