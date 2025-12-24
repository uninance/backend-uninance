package com.uninance.backend.dto.SpentDTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SpentResponseDTO {

    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;

    private Long userId;
    private Long accountId;
    private Long categoryId;
}