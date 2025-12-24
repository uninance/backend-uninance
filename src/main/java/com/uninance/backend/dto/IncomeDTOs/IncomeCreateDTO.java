package com.uninance.backend.dto.IncomeDTOs;

import lombok.Data;

@Data
public class IncomeCreateDTO {

    private Double amount;
    private String description;

}