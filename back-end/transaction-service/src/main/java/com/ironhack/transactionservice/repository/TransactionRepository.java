package com.ironhack.transactionservice.repository;

import com.ironhack.transactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllBySenderId(Long id);
    List<Transaction> findAllBySenderAccountId(Long id);
    List<Transaction> findAllByReceiverId(Long id);
    List<Transaction> findAllByReceiverAccountId(Long id);
    List<Transaction> findAllByConcept(String concept);
}
