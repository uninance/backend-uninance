package com.uninance.backend.dto.UserDTOs;

import lombok.Data;

@Data
public class UserListResponseDTO {
    private Long id;
    private String name; 
    private String email;
    private boolean active;
}
