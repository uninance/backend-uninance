package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.UserEntity;

public interface UserService {

    UserEntity createUser(UserEntity user);

    void changePassword(Long userId, String newPassword);

    UserEntity findUserById(Long userId);

    List<UserEntity> findAllUsers();

    void updateProfile(Long userId, String name, String lastName);

    void deleteUser(Long userId);

    boolean existsByEmail(String email);

    UserEntity findByEmail(String email);

    void deactivateUser(Long userId);

    void activateUser(Long userId);

    Double checkTotalBalance(Long userId);


}
