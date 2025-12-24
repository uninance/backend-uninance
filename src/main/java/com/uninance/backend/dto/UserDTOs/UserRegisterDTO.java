package com.uninance.backend.dto.UserDTOs;
import lombok.Data;

@Data
public class UserRegisterDTO {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
