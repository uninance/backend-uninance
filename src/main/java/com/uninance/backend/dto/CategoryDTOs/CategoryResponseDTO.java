package com.uninance.backend.dto.CategoryDTOs;

import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String type;
    private String icon;
    private boolean userCreated;
}