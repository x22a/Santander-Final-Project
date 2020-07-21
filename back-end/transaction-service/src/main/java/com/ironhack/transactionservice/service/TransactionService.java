package com.ironhack.transactionservice.service;

import com.ironhack.transactionservice.model.Transaction;
import com.ironhack.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Optional;

/**
 * Transaction Service
 */
@Service
public class TransactionService {
    /**
     * Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(TransactionService.class);

    /**
     * Transaction Repository
     */
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Get Transaction by ID
     * @param id Long id
     * @return Transaction with provided ID
     */
    public Transaction findById(Long id){
        LOGGER.info("[INIT] - Find Transaction with ID: " + id);
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            LOGGER.warn("[WARN] - Transaction with id " + id + " not found");
            return null;
        }
        LOGGER.info("[END] - Found Transaction with ID: " + id);
        return transaction.get();
    }

    /**
     * Get all Transactions
     * @return List of Transactions
     */
    public List<Transaction> findAll(){
        LOGGER.info("[INFO] - Find all Transactions");
        return transactionRepository.findAll();
    }

    /**
     * Get all Transactions by sender id
     * @param id Long sender id
     * @return List of Transactions
     */
    public List<Transaction> findAllBySenderId(Long id) {
        return transactionRepository.findAllBySenderId(id);
    }

    /**
     * Get all Transactions by sender account id
     * @param id Long sender account id
     * @return List of Transactions
     */
    public List<Transaction> findAllBySenderAccountId(Long id) {
        return transactionRepository.findAllBySenderAccountId(id);
    }

    /**
     * Get all Transactions by receiver id
     * @param id Long receiver id
     * @return List of Transactions
     */
    public List<Transaction> findAllByReceiverId(Long id) {
        return transactionRepository.findAllByReceiverId(id);
    }

    /**
     * Get all Transactions by receiver account id
     * @param id Long receiver account id
     * @return List of Transactions
     */

    public List<Transaction> findAllByReceiverAccountId(Long id) {
        return transactionRepository.findAllByReceiverAccountId(id);
    }

    /**
     * Create Transaction
     * @param transaction Transaction
     * @return Transaction
     */
    public Transaction save(Transaction transaction, HttpHeaders headers){
        System.out.println(headers);
        LOGGER.info("[INFO] - New Transaction with ID: " + transaction.getId());
        return transactionRepository.save(transaction);
    }
}
