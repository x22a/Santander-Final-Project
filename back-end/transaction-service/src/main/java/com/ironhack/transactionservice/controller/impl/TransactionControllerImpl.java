package com.ironhack.transactionservice.controller.impl;

import com.ironhack.transactionservice.model.Transaction;
import com.ironhack.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Implementation of Transaction Controller
 */
@RestController
public class TransactionControllerImpl {
    /**
     * Transaction Service
     */
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
     * Get all Transactions by sender id
     * @param id Long sender id
     * @return List of Transactions
     */
    @GetMapping("/transactions/sender/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllBySenderId(@PathVariable Long id) {
        return transactionService.findAllBySenderId(id);
    }

    /**
     * Get all Transactions by sender account id
     * @param id Long sender account id
     * @return List of Transactions
     */
    @GetMapping("/transactions/sender/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllBySenderAccountId(@PathVariable Long id) {
        return transactionService.findAllBySenderAccountId(id);
    }

    /**
     * Get all Transactions by receiver id
     * @param id Long receiver id
     * @return List of Transactions
     */
    @GetMapping("/transactions/receiver/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllByReceiverId(@PathVariable Long id) {
        return transactionService.findAllByReceiverId(id);
    }

    /**
     * Get all Transactions by receiver account id
     * @param id Long receiver account id
     * @return List of Transactions
     */
    @GetMapping("/transactions/receiver/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllByReceiverAccountId(@PathVariable Long id) {
        return transactionService.findAllByReceiverAccountId(id);
    }

    /**
     * Create Transaction
     * @param transaction Transaction to create
     * @return Contact created
     */
    @PostMapping("/transactions/")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction save(@RequestBody @Valid Transaction transaction, @RequestHeader HttpHeaders headers) {
        return transactionService.save(transaction, headers);
    }


}
