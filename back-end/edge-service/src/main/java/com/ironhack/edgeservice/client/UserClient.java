package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-client", url = "http://localhost:8086")
public interface UserClient {
    @GetMapping("/users/{username}")
    User findByUsername(@PathVariable String username);

    @GetMapping("/user/{id}")
    User findById(@PathVariable Long id);

    @GetMapping("/users")
    List<User> findAllUsers();

    @PostMapping("/auth/sign-in")
    User createUser(@RequestBody User user);

}