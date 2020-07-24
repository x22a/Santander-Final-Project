package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * Get all Accounts by OwnerId
     * @return List of Accounts
     */
    @GetMapping("/accounts/owner/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllByOwnerId(@PathVariable String username) {
        return accountService.findAllByOwnerUsername(username);
    }

    /**
     * Create Account
     * @param account Account to create
     * @return Account created
     */
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account save(@RequestBody @Valid Account account) {
        return accountService.save(account);
    }
}
