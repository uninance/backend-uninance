package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.TransactionEntity;

public interface TransactionService {

    TransactionEntity createTransaction(TransactionEntity transaction);

    TransactionEntity findTransactionById(Long transactionId);

    List<TransactionEntity> findTransactionsByUser(Long userId);

    void deleteTransaction(Long transactionId);
}