package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.uninance.backend.entities.AccountEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.AccountRepository;
import com.uninance.backend.services.AccountService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final UserService userService;

    @Override
    public AccountEntity createAccount(Long userId, AccountEntity account) {
        UserEntity user = userService.findUserById(userId);
        account.setUser(user);
        return accountRepository.save(account);
    }


    @Override
    public AccountEntity findAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<AccountEntity> findAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId);
    }


    @Override
    public void modifyAccountName(Long accountId, String newName){
        AccountEntity existingAccount = findAccount(accountId);
        if (newName != null && !newName.isBlank()){
            existingAccount.setName(newName);
        }
        accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long accountId){
        AccountEntity account = findAccount(accountId);
        accountRepository.delete(account);
    }


    @Override
    public void updateBalance(Long accountId, Double amount){
        AccountEntity account = findAccount(accountId);
        if (account.getBalance() + amount < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    
}
