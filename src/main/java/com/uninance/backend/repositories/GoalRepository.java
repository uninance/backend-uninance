package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.GoalEntity;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {

    List<GoalEntity> findByUserId(Long userId);
}