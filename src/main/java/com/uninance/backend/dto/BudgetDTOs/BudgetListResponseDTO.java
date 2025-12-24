package com.uninance.backend.dto.BudgetDTOs;

import java.util.List;
import lombok.Data;

@Data
public class BudgetListResponseDTO {
    private List<BudgetResponseDTO> budgets;
}