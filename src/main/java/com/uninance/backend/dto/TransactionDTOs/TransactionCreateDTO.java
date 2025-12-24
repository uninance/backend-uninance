package com.uninance.backend.dto.TransactionDTOs;

import lombok.Data;

@Data
public class TransactionCreateDTO {

    private Long originAccountId;
    private Long destinyAccountId;
    private Double amount;
    private String description;
}