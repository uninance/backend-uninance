package com.uninance.backend.dto.CategoryDTOs;

import lombok.Data;

@Data
public class CategoryCreateDTO {
    private String name;
    private String type;   // "Income" o "Spent"
    private String icon;
}