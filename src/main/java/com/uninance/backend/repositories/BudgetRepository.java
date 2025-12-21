package com.uninance.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.BudgetEntity;

public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {

    Optional<BudgetEntity> findByCategoryId(Long categoryId);

    List<BudgetEntity> findByUserId(Long userId);

    boolean existsByCategoryId(Long categoryId);
}