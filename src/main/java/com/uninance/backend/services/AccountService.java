package com.uninance.backend.services;
import java.util.List;

import com.uninance.backend.entities.AccountEntity;;

public interface AccountService {
    
    AccountEntity createAccount(Long userId, AccountEntity account);

    AccountEntity findAccount(Long accountId);

    List<AccountEntity> findAccountsByUser(Long userId);

    void modifyAccountName(Long accountId, String newName);

    void deleteAccount(Long accountId);

    void updateBalance(Long accountId, Double amount);

}
