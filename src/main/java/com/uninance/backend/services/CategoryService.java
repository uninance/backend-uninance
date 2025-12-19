package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.CategoryEntity;

public interface CategoryService {

    CategoryEntity createCategory(Long userId, CategoryEntity category);

    CategoryEntity findCategoryById(Long categoryId);

    List<CategoryEntity> findCategoriesByUser(Long userId);

    List<CategoryEntity> findDefaultCategories();

    void updateCategory(Long categoryId, String name, String icon);

    void deleteCategory(Long categoryId);
}
