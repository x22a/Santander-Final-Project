package com.ironhack.userservice.service;

import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createUser(@RequestBody @Valid User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findById(@PathVariable Long id){
        Optional<User> foundUser = userRepository.findById(id);
        if (!foundUser.isPresent()){
            return null;
        }
        return foundUser.get();
    }

    public User findByUsername(@PathVariable String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (!foundUser.isPresent()){
            return null;
        }
        return foundUser.get();
    }





    //public User findByEmail(String email) {
    //    return userRepository.findByEmail(email);
    //}

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
