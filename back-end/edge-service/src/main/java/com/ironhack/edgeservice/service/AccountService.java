package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.AccountClient;
import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private UserClient userClient;
    /**
     * Get all Accounts by OwnerId
     * @return List of Accounts
     */
    public List<Account> findAllByOwnerUsername(String username) {
        User user = userClient.findByUsername(username);
        return accountClient.findAllByOwnerUsername(user.getId());
    }


    /**
     * Create Account
     * @param account Account to create
     * @return Account created
     */
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account save(@RequestBody @Valid Account account) {
        return accountClient.save(account);
    }
}
