package com.uninance.backend.dto.GoalDTOs;

import java.time.LocalDate;

import lombok.Data;

@Data
public class GoalCreateDTO {
    private String name;
    private Double targetAmount;
    private Boolean deadlineGoal;
    private LocalDate deadline; // opcional, solo si deadlineGoal = true
}
