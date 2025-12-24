package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.AccountEntity;
import com.uninance.backend.entities.TransactionEntity;
import com.uninance.backend.repositories.TransactionRepository;
import com.uninance.backend.services.AccountService;
import com.uninance.backend.services.TransactionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Override
    public TransactionEntity createTransaction(TransactionEntity transaction) {

        AccountEntity origin = accountService.findAccount(
                transaction.getOriginAccount().getId()
        );

        AccountEntity destiny = accountService.findAccount(
                transaction.getDestinyAccount().getId()
        );

        Double amount = transaction.getAmount();

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if (origin.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // actualizar balances
        origin.setBalance(origin.getBalance() - amount);
        destiny.setBalance(destiny.getBalance() + amount);

        // guardar transferencia
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionEntity findTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public List<TransactionEntity> findTransactionsByUser(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        if (!transactionRepository.existsById(transactionId)) {
            throw new RuntimeException("Transaction not found");
        }
        transactionRepository.deleteById(transactionId);
    }
}