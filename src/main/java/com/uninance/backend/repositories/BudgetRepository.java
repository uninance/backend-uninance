package com.uninance.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.BudgetEntity;
import com.uninance.backend.entities.CategoryEntity;

public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {

    Optional<BudgetEntity> findByCategory(CategoryEntity category);
}
