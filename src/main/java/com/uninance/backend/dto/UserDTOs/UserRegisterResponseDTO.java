package com.uninance.backend.dto.UserDTOs;

import lombok.Data;

@Data
public class UserRegisterResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private boolean active;
}
