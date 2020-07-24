package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.UserClient;

import com.ironhack.edgeservice.config.FeignBadResponseWrapper;
import com.ironhack.edgeservice.exceptions.UserAlreadyExistsException;
import com.ironhack.edgeservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserClient userClient;


    public User createUser(@RequestBody @Valid User user) {
        User foundUser = userClient.findByUsername(user.getUsername());
        if (foundUser != null){
            throw new UserAlreadyExistsException("User " + user.getUsername() + " already exists");
        }
        return userClient.createUser(user);
    }

    @HystrixCommand(fallbackMethod = "findUserByIdFake", ignoreExceptions = FeignBadResponseWrapper.class)
    public User findUserById(Long id){
        User user = null;
        try {
            user = userClient.findById(id);
        } catch (HystrixBadRequestException e) {
            if (e instanceof FeignBadResponseWrapper) {
                throw new FeignBadResponseWrapper(((FeignBadResponseWrapper) e).getStatus(), ((FeignBadResponseWrapper) e).getHeaders(), ((FeignBadResponseWrapper) e).getBody());
            }
        }
        return user;
    }

    public User findUserByIdFake(Long id){
        throw new NullPointerException("User service is down. Try again Later");
    }

    @HystrixCommand(fallbackMethod = "findUserByUsernameFake", ignoreExceptions = FeignBadResponseWrapper.class)
    public User findUserByUsername(String username){
        User user = null;
        try {
            user = userClient.findByUsername(username);
        } catch (HystrixBadRequestException e) {
            if (e instanceof FeignBadResponseWrapper) {
                throw new FeignBadResponseWrapper(((FeignBadResponseWrapper) e).getStatus(), ((FeignBadResponseWrapper) e).getHeaders(), ((FeignBadResponseWrapper) e).getBody());
            }
        }
        return user;
    }

    public User findUserByUsernameFake(String username){
        throw new NullPointerException("User service is down. Try again Later");
    }

    @HystrixCommand(fallbackMethod = "findAllUsersFake")
    public List<User> findAllUsers(){
        return userClient.findAllUsers();
    }

    public List<User> findAllUsersFake(){
        throw new NullPointerException("User service is down. Try again Later");
    }
}
