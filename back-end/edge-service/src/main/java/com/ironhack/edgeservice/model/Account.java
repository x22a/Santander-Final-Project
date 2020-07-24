package com.ironhack.edgeservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Account
 */
public class Account {
    /**
     * Id of the Account
     */
    private Long id;

    /**
     * Amount in the Account
     */
    @NotNull(message = "Amount cannot be null")
    private Money balance;

    /**
     * Id of the owner
     */
    @NotNull(message = "Owner id cannot be null")
    private Long ownerId;

    /**
     * Default Constructor of the Account
     */
    public Account() {
    }

    /**
     * Get id of the Account
     * @return id Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id of the Account
     * @param id Long id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get amount in the Account
     * @return amount Money amount
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * Set amount in the Account
     * @param balance Money amount
     */
    public void setBalance(Money balance) {
        this.balance = balance;
    }

    /**
     * Get owner id of the Account
     * @return ownerId Long ownerId
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Set owner id of the Account
     * @param ownerId Long ownerId
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
