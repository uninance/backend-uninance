package com.uninance.backend.dto.BudgetDTOs;

import lombok.Data;

@Data
public class BudgetResponseDTO {
    private Long id;
    private Double limitAmount;
    private String period;

    private Long categoryId;
    private String categoryName;

    private Long userId;
}