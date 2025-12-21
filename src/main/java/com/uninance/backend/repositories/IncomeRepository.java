package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.IncomeEntity;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {

    List<IncomeEntity> findByUserId(Long userId);

    List<IncomeEntity> findByAccountId(Long accountId);

    List<IncomeEntity> findByCategoryId(Long categoryId);
}