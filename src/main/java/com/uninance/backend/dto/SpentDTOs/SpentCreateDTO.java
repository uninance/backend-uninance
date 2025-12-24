package com.uninance.backend.dto.SpentDTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SpentCreateDTO {

    private BigDecimal amount;
    private String description;
    private LocalDateTime date;
}