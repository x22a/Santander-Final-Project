package com.ironhack.edgeservice.controller;

import com.ironhack.edgeservice.model.Transaction;
import com.ironhack.edgeservice.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.security.Principal;
import java.util.List;


@RestController
public class TransactionControllerImpl {

    @Autowired
    private TransactionService transactionService;

    /**
     * Get Transaction by ID
     * @param id Long id
     * @return Transaction with provided ID
     */
    @GetMapping("/transactions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    /**
     * Get all Transactions
     * @return List of Transactions
     */
    @GetMapping("/transactions/")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    /**
     * Create Transaction
     * @param transaction Transaction to create
     * @return Contact created
     */
    @PostMapping("/transactions/")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction save(@RequestBody @Valid Transaction transaction) {

        return transactionService.save(transaction);
    }

    /**
     * Get all Transactions by sender account id
     * @param id Long sender account id
     * @return List of Transactions
     */
    @GetMapping("/transactions/sender/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllBySenderAccountId(@PathVariable Long id) {
        System.out.println(id);
        return transactionService.findAllBySenderAccountId(id);
    }

}
