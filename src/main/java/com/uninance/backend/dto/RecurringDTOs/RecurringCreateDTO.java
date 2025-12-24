package com.uninance.backend.dto.RecurringDTOs;

import java.time.LocalDateTime;

import com.uninance.backend.enums.GitEnum;
import com.uninance.backend.enums.PeriodEnums;

import lombok.Data;

@Data
public class RecurringCreateDTO {

    private Double amount;
    private PeriodEnums period;
    private GitEnum type;

    private LocalDateTime nextExecution;
    private LocalDateTime endDate;

    private String description;

    private Long categoryId;
    private Long accountId;
}