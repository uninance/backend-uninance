package com.uninance.backend.dto.AccountDTOs;

import lombok.Data;

@Data
public class AccountCreatedDTO {
    private String name;
    private Double balance;
    private String type;
}
