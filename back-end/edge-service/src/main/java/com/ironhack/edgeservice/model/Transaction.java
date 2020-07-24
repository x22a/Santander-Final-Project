package com.ironhack.edgeservice.model;

import com.ironhack.edgeservice.enums.Concept;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Transaction
 */
@Entity
public class Transaction {
    /**
     * Id of the Transaction
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Id of the sender account
     */
    @NotNull(message = "Sender account id cannot be null")
    private Long senderAccountId;


    /**
     * Id of the receiver account
     */
    @NotNull(message = "Receiver account id cannot be null")
    private Long receiverAccountId;

    /**
     * Amount of the transaction
     */
    @NotNull(message = "Amount cannot be null")
    @Embedded
    private Money amount;

    /**
     * Concept of the transaction
     */
    @NotNull(message = "Concept cannot be null")
    @Enumerated(value = EnumType.STRING)
    private Concept concept;

    private LocalDateTime date;

    /**
     * Default Constructor of the Transaction
     */
    public Transaction() {
        this.date = LocalDateTime.now();
    }

    /**
     * Get id of the transaction
     * @return id Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id of the transaction
     * @param id Long id
     */
    public void setId(Long id) {
        this.id = id;
    }





    /**
     * Get sender account id
     * @return senderAccountId Long id
     */
    public Long getSenderAccountId() {
        return senderAccountId;
    }

    /**
     * Set sender account id
     * @param senderAccountId Long senderAccountId
     */
    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }



    /**
     * Get receiver account id
     * @return receiverAccountId Long receiverAccountId
     */
    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    /**
     * Set receiver account id
     * @param receiverAccountId Long receiverAccountID
     */
    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    /**
     * Get amount
     * @return amount Money amount
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * Set amount
     * @param amount Money amount
     */
    public void setAmount(Money amount) {
        this.amount = amount;
    }

    /**
     * Get concept
     * @return concept String concept
     */
    public Concept getConcept() {
        return concept;
    }

    /**
     * Set concept
     * @param concept String concept
     */
    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    /**
     * Get date
     * @return date LocalDateTime date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Set date
     * @param date LocalDateTime date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
