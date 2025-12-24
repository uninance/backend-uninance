package com.uninance.backend.dto.AccountDTOs;

import lombok.Data;

@Data
public class AccountResponseDTO {
    private Long id;
    private String name;
    private Double balance;
    private String type;
}
