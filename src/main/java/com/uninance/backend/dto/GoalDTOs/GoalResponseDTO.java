package com.uninance.backend.dto.GoalDTOs;

import java.time.LocalDate;

import lombok.Data;

@Data
public class GoalResponseDTO {
    private Long id;
    private String name;
    private Double targetAmount;
    private Double currentAmount;
    private Boolean deadlineGoal;
    private LocalDate deadline;
}
