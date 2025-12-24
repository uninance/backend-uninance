package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.BudgetEntity;
import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.BudgetRepository;
import com.uninance.backend.services.BudgetService;
import com.uninance.backend.services.CategoryService;
import com.uninance.backend.services.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    @Override
    @Transactional
    public BudgetEntity createBudget(Long userId, Long categoryId, BudgetEntity budget) {

        if (budgetRepository.existsByCategoryId(categoryId)) {
            throw new RuntimeException("This category already has a budget");
        }

        UserEntity user = userService.findUserById(userId);
        CategoryEntity category = categoryService.findCategoryById(categoryId);

        budget.setUser(user);
        budget.setCategory(category);

        return budgetRepository.save(budget);
    }

    @Override
    public BudgetEntity findBudgetById(Long budgetId) {
        return budgetRepository.findById(budgetId)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    @Override
    public BudgetEntity findBudgetByCategory(Long categoryId) {
        return budgetRepository.findByCategoryId(categoryId)
                .orElseThrow(() -> new RuntimeException("Budget not found for category"));
    }

    @Override
    public List<BudgetEntity> findBudgetsByUser(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    @Override
    public void updateLimit(Long budgetId, Double newLimit) {
        if (newLimit == null || newLimit <= 0) {
            throw new RuntimeException("Invalid limit");
        }

        BudgetEntity budget = findBudgetById(budgetId);
        budget.setLimitAmount(newLimit);

        budgetRepository.save(budget);
    }

    @Override
    public void deleteBudget(Long budgetId) {
        if (!budgetRepository.existsById(budgetId)) {
            throw new RuntimeException("Budget not found");
        }
        budgetRepository.deleteById(budgetId);
    }

    @Override
    public boolean existsByCategory(Long categoryId) {
        return budgetRepository.existsByCategoryId(categoryId);
    }
}