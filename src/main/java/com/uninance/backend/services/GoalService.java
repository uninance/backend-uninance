package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.GoalEntity;

public interface GoalService {

    GoalEntity createGoal(Long userId, GoalEntity goal);

    GoalEntity findGoalById(Long goalId);

    List<GoalEntity> findGoalsByUser(Long userId);

    void updateGoal(Long goalId, String name, Double targetAmount, Boolean deadlineGoal);

    void addAmount(Long goalId, Double amount);

    void deleteGoal(Long goalId);
}