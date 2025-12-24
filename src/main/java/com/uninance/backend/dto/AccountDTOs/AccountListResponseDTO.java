package com.uninance.backend.dto.AccountDTOs;

import java.util.List;

import lombok.Data;

@Data
public class AccountListResponseDTO {
    private List<AccountResponseDTO> accounts;
}
