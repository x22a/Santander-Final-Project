package com.ironhack.accountservice.controller.impl;

import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Implementation of Account Controller
 */
@RestController
public class AccountControllerImpl {
    /**
     * Account Service
     */
    @Autowired
    private AccountService accountService;

    /**
     * Get Account by ID
     * @param id Long id
     * @return Account with provided ID
     */
    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    /**
     * Get all Accounts
     * @return List of Accounts
     */
    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll() {
        return accountService.findAll();
    }

    /**
     * Get all Accounts by OwnerId
     * @return List of Accounts
     */
    @GetMapping("/accounts/owner/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllByOwnerUsername(@PathVariable Long id) {
        return accountService.findAllByOwnerId(id);
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
