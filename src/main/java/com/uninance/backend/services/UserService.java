package com.uninance.backend.services;

import com.uninance.backend.entities.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity saveUser(UserEntity user);

    Optional<UserEntity> getUserById(Long id);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(Long id, UserEntity newUserData);

    void deleteUser(Long id);
}
