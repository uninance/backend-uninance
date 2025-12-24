package com.uninance.backend.dto.GoalDTOs;

import lombok.Data;

@Data
public class GoalSummaryDTO {
    private Long id;
    private String name;
    private Double targetAmount;
    private Double currentAmount;
}
