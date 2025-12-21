package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.AccountEntity;
import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.IncomeEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.IncomeRepository;
import com.uninance.backend.services.AccountService;
import com.uninance.backend.services.CategoryService;
import com.uninance.backend.services.IncomeService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserService userService;
    private final AccountService accountService;
    private final CategoryService categoryService;

    @Override
    public IncomeEntity createIncome(
            Long userId,
            Long accountId,
            Long categoryId,
            IncomeEntity income) {

        UserEntity user = userService.findUserById(userId);
        AccountEntity account = accountService.findAccount(accountId);
        CategoryEntity category = categoryService.findCategoryById(categoryId);

        income.setUser(user);
        income.setAccount(account);
        income.setCategory(category);

        accountService.updateBalance(accountId, income.getAmount());

        return incomeRepository.save(income);
    }

    @Override
    public IncomeEntity findIncomeById(Long incomeId) {
        return incomeRepository.findById(incomeId)
                .orElseThrow(() -> new RuntimeException("Income not found"));
    }

    @Override
    public List<IncomeEntity> findIncomesByUser(Long userId) {
        return incomeRepository.findByUserId(userId);
    }

    @Override
    public List<IncomeEntity> findIncomesByAccount(Long accountId) {
        return incomeRepository.findByAccountId(accountId);
    }

    @Override
    public void deleteIncome(Long incomeId) {
        IncomeEntity income = findIncomeById(incomeId);

        // Restar el ingreso del balance
        accountService.updateBalance(
                income.getAccount().getId(),
                -income.getAmount()
        );

        incomeRepository.delete(income);
    }
}