package com.uninance.backend.dto.IncomeDTOs;

import java.util.List;
import lombok.Data;

@Data
public class IncomeListResponseDTO {

    private List<IncomeResponseDTO> incomes;
}