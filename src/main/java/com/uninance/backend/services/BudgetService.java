package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.BudgetEntity;

public interface BudgetService {

    BudgetEntity createBudget(Long userId, Long categoryId, BudgetEntity budget);

    BudgetEntity findBudgetById(Long budgetId);

    BudgetEntity findBudgetByCategory(Long categoryId);

    List<BudgetEntity> findBudgetsByUser(Long userId);

    void updateLimit(Long budgetId, Double newLimit);

    void deleteBudget(Long budgetId);

    boolean existsByCategory(Long categoryId);
}