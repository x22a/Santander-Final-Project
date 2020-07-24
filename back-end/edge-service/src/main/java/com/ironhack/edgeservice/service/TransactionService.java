package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.TransactionClient;
import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.model.SecurityUser;
import com.ironhack.edgeservice.model.Transaction;
import com.ironhack.edgeservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionClient transactionClient;

    @Autowired
    private UserClient userClient;

    /**
     * Get Transaction by ID
     * @param id Long id
     * @return Transaction with provided ID
     */

    public Transaction findById(Long id) {
        return transactionClient.findById(id);
    }

    /**
     * Get all Transactions
     * @return List of Transactions
     */
    public List<Transaction> findAll() {
        return transactionClient.findAll();
    }

    /**
     * Create Transaction
     * @param transaction Transaction
     * @return Transaction
     */
    public Transaction save(Transaction transaction){
        return transactionClient.save(transaction);
    }

    /**
     * Get all Transactions by sender account id
     * @param id Long sender account id
     * @return List of Transactions
     */
    public List<Transaction> findAllBySenderAccountId(Long id) {
        return transactionClient.findAllBySenderAccountId(id);
    }
}
