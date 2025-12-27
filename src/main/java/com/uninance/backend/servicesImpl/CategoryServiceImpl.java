package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.CategoryRepository;
import com.uninance.backend.services.CategoryService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;

    @Override
    public CategoryEntity createCategory(Long userId, CategoryEntity category) {
        UserEntity user = userService.findUserById(userId);

        category.setUser(user);
        category.setUserCreated(true);

        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<CategoryEntity> findCategoriesByUser(Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    @Override
    public List<CategoryEntity> findDefaultCategories() {
        return categoryRepository.findByUserCreatedFalse();
    }

    @Override
    public void updateCategory(Long categoryId, String name, String icon) {
        CategoryEntity category = findCategoryById(categoryId);

        if (name != null && !name.isBlank()) {
            category.setName(name);
        }

        if (icon != null && !icon.isBlank()) {
            category.setIcon(icon);
        }

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void createDefaultSpentCategories(UserEntity user) {

        List<CategoryEntity> defaults = List.of(
            createSpentCategory("Food", "food", user),
            createSpentCategory("Transport", "bus", user),
            createSpentCategory("Health", "health", user),
            createSpentCategory("Entertainment", "entertainment", user),
            createSpentCategory("Emergency", "entertainment", user),
            createSpentCategory("Dwelling", "dwelling", user),
            createSpentCategory("Services", "services", user),
            createSpentCategory("Education", "education", user)
        );

        categoryRepository.saveAll(defaults);
    }

    @Override
    public CategoryEntity createSpentCategory(String name, String icon, UserEntity user) {
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        category.setType("Spent");
        category.setIcon(icon);
        category.setUserCreated(false);
        category.setUser(user);
        return category;
    }

        @Override
    public void createDefaultIncomeCategories(UserEntity user) {

        List<CategoryEntity> defaults = List.of(
            createIncomeCategory("Salary", "salary", user),
            createIncomeCategory("Sales", "sales", user),
            createIncomeCategory("Extra Incomes", "health", user),
            createIncomeCategory("Freelance", "entertainment", user),
            createIncomeCategory("Bonus", "entertainment", user),
            createIncomeCategory("Investing Returns", "ir", user)
        );

        categoryRepository.saveAll(defaults);
    }

    @Override
    public CategoryEntity createIncomeCategory(String name, String icon, UserEntity user) {
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        category.setType("Income");
        category.setIcon(icon);
        category.setUserCreated(false);
        category.setUser(user);
        return category;
    }
}
