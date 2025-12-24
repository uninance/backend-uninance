package com.uninance.backend.dto.GoalDTOs;

import lombok.Data;

@Data
public class GoalUpdateDTO {
    private String name;
    private Double targetAmount;
    private Boolean deadlineGoal;
}
