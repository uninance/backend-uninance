package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.UserEntity;

public interface CategoryService {

    CategoryEntity createCategory(Long userId, CategoryEntity category);

    CategoryEntity findCategoryById(Long categoryId);

    List<CategoryEntity> findCategoriesByUser(Long userId);

    List<CategoryEntity> findDefaultCategories();

    void updateCategory(Long categoryId, String name, String icon);

    void deleteCategory(Long categoryId);

    void createDefaultSpentCategories(Long userId);

    CategoryEntity createSpentCategory(String name, String icon, UserEntity user);

    void createDefaultIncomeCategories(Long userId);

    CategoryEntity createIncomeCategory(String name, String icon, UserEntity user);
}
