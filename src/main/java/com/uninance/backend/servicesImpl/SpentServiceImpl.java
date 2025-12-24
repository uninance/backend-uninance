package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.AccountEntity;
import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.SpentEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.AccountRepository;
import com.uninance.backend.repositories.CategoryRepository;
import com.uninance.backend.repositories.SpentRepository;
import com.uninance.backend.services.SpentService;
import com.uninance.backend.services.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpentServiceImpl implements SpentService {

    private final SpentRepository spentRepository;
    private final UserService userService;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public SpentEntity createSpent(Long userId, Long accountId, Long categoryId, SpentEntity spent) {

        UserEntity user = userService.findUserById(userId);
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        spent.setUser(user);
        spent.setAccount(account);
        spent.setCategory(category);

        // actualizar balance
        if (account.getBalance() - spent.getAmount() < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - spent.getAmount());

        return spentRepository.save(spent);
    }

    @Override
    public SpentEntity findSpentById(Long spentId) {
        return spentRepository.findById(spentId)
                .orElseThrow(() -> new RuntimeException("Spent not found"));
    }

    @Override
    public List<SpentEntity> findSpentsByUser(Long userId) {
        return spentRepository.findByUserId(userId);
    }

    @Override
    public List<SpentEntity> findSpentsByAccount(Long accountId) {
        return spentRepository.findByAccountId(accountId);
    }

    @Override
    public List<SpentEntity> findSpentsByCategory(Long categoryId) {
        return spentRepository.findByCategoryId(categoryId);
    }

    @Override
    public void deleteSpent(Long spentId) {
        if (!spentRepository.existsById(spentId)) {
            throw new RuntimeException("Spent not found");
        }
        spentRepository.deleteById(spentId);
    }
}