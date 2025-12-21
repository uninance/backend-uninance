package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.SpentEntity;

public interface SpentService {

    SpentEntity createSpent(Long userId, Long accountId, Long categoryId, SpentEntity spent);

    SpentEntity findSpentById(Long spentId);

    List<SpentEntity> findSpentsByUser(Long userId);

    List<SpentEntity> findSpentsByAccount(Long accountId);

    List<SpentEntity> findSpentsByCategory(Long categoryId);

    void deleteSpent(Long spentId);
}       