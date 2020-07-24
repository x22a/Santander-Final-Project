package com.ironhack.accountservice.service;

import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.repository.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Account Service
 */
@Service
public class AccountService {
    /**
     * Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);
    /**
     * Account Repository
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Get Account by ID
     * @param id Long id
     * @return Account with provided ID
     */
    public Account findById(Long id){
        LOGGER.info("[INIT] - Find Account with ID: " + id);
        Optional<Account> account = accountRepository.findById(id);
        if (!account.isPresent()) {
            LOGGER.warn("[WARN] - Account with id " + id + " not found");
            return null;
        }
        LOGGER.info("[END] - Found Account with ID: " + id);
        return account.get();
    }

    /**
     * Get all Accounts
     * @return List of Accounts
     */
    public List<Account> findAll(){
        LOGGER.info("[INFO] - Find all Accounts");
        return accountRepository.findAll();
    }

    /**
     * Get all Accounts by Owner id
     * @return List of Accounts
     */
    public List<Account> findAllByOwnerId(Long id){
        LOGGER.info("[INFO] - Find all Accounts for owner id " + id);
        return accountRepository.findAllByOwnerId(id);
    }

    /**
     * Create Account
     * @param account Account
     * @return Transaction
     */
    public Account save(Account account){
        accountRepository.save(account);
        LOGGER.info("[INFO] - New Account with ID: " + account.getId());
        return accountRepository.save(account);
    }
}
