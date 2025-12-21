package com.uninance.backend.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.GoalEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.GoalRepository;
import com.uninance.backend.services.GoalService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final UserService userService;

    @Override
    public GoalEntity createGoal(Long userId, GoalEntity goal) {
        UserEntity user = userService.findUserById(userId);
        goal.setUser(user);
        goal.setCurrentAmount(0.0);
        return goalRepository.save(goal);
    }

    @Override
    public GoalEntity findGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found"));
    }

    @Override
    public List<GoalEntity> findGoalsByUser(Long userId) {
        return goalRepository.findByUserId(userId);
    }

    @Override
    public void updateGoal(Long goalId, String name, Double targetAmount, Boolean deadlineGoal) {
        GoalEntity goal = findGoalById(goalId);

        if (name != null && !name.isBlank()) {
            goal.setName(name);
        }

        if (targetAmount != null && targetAmount > 0) {
            goal.setTargetAmount(targetAmount);
        }

        if (deadlineGoal != null) {
            goal.setDeadlineGoal(deadlineGoal);
            if (!deadlineGoal) {
                goal.setDeadline(null);
            }
        }

        goalRepository.save(goal);
    }

    @Override
    public void addAmount(Long goalId, Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        GoalEntity goal = findGoalById(goalId);
        goal.setCurrentAmount(goal.getCurrentAmount() + amount);

        goalRepository.save(goal);
    }

    @Override
    public void deleteGoal(Long goalId) {
        if (!goalRepository.existsById(goalId)) {
            throw new RuntimeException("Goal not found");
        }
        goalRepository.deleteById(goalId);
    }
}