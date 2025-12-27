package com.uninance.backend.servicesImpl;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.services.CategoryService;
import com.uninance.backend.services.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserService userService;
    private final CategoryService categoryService;

    @Transactional
    public UserEntity registerUser(UserEntity user) {

        UserEntity savedUser = userService.createUser(user);

        categoryService.createDefaultSpentCategories(savedUser);
        categoryService.createDefaultIncomeCategories(savedUser);

        return savedUser;
    }
}