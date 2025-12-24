package com.uninance.backend.dto.RecurringDTOs;

import java.time.LocalDateTime;

import com.uninance.backend.enums.GitEnum;
import com.uninance.backend.enums.PeriodEnums;

import lombok.Data;

@Data
public class RecurringResponseDTO {

    private Long id;

    private Double amount;
    private PeriodEnums period;
    private GitEnum type;

    private boolean active;

    private LocalDateTime nextExecution;
    private LocalDateTime endDate;

    private String description;

    private Long userId;
    private Long categoryId;
    private Long accountId;
}