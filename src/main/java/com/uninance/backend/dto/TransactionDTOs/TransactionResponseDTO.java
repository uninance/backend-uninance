package com.uninance.backend.dto.TransactionDTOs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionResponseDTO {

    private Long id;

    private Long originAccountId;
    private Long destinyAccountId;

    private Double amount;
    private String description;

    private LocalDateTime createdAt;
}