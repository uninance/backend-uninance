package com.uninance.backend.dto.IncomeDTOs;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IncomeResponseDTO {

    private Long id;
    private Double amount;
    private String description;
    private LocalDateTime createdAt;

    private Long accountId;
    private String accountName;

    private Long categoryId;
    private String categoryName;
}