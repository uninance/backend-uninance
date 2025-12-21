package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByUserId(Long userId);

    List<TransactionEntity> findByOriginAccountIdOrDestinyAccountId(Long originAccountId, Long destinyAccountId);
}