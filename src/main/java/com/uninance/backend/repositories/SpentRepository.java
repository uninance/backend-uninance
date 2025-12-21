package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.SpentEntity;

public interface SpentRepository extends JpaRepository<SpentEntity, Long> {

    List<SpentEntity> findByUserId(Long userId);

    List<SpentEntity> findByAccountId(Long accountId);

    List<SpentEntity> findByCategoryId(Long categoryId);
}