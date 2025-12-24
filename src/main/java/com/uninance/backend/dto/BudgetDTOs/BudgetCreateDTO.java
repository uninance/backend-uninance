package com.uninance.backend.dto.BudgetDTOs;

import lombok.Data;

@Data
public class BudgetCreateDTO {
    private Double limitAmount;
    private String period; // DAILY, MONTHLY, etc (PeriodEnums como String)
}