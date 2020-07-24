package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.SecurityUser;
import com.ironhack.edgeservice.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Feign Client Interface for Transaction Service
 */
@FeignClient(name = "transaction-service", url = "http://localhost:8084")
public interface TransactionClient {

    /**
     * Get Transaction by ID
     * @param id Long id
     * @return Transaction with provided ID
     */
    @GetMapping("/transactions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction findById(@PathVariable Long id);

    /**
     * Get all Transactions
     * @return List of Transactions
     */
    @GetMapping("/transactions/")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAll();

    /**
     * Create Transaction
     * @param transaction Transaction to create
     * @return Contact created
     */
    @PostMapping("/transactions/")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction save(@RequestBody @Valid Transaction transaction);

    /**
     * Get all Transactions by sender account id
     * @param id Long sender account id
     * @return List of Transactions
     */
    @GetMapping("/transactions/sender/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findAllBySenderAccountId(@PathVariable Long id);


}
