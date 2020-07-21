package com.ironhack.authservice.controller.impl;

import com.ironhack.authservice.model.SecurityUser;
import com.ironhack.authservice.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SecurityUserControllerImpl {
    @Autowired
    private SecurityUserService securityUserService;

    /**
     * Create SecurityUser
     * @param securityUser Account to create
     * @return SecurityUser created
     */
    @PostMapping("/auth/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    public SecurityUser save(@RequestBody @Valid SecurityUser securityUser) {
        return securityUserService.save(securityUser);
    }
}
