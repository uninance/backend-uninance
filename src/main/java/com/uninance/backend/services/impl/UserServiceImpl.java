package com.uninance.backend.services.impl;

import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.UserRepository;
import com.uninance.backend.services.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Spring inyecta el repo automáticamente gracias a @Service
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity newUserData) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUserData.getUsername());
                    user.setPassword(newUserData.getPassword());
                    user.setEmail(newUserData.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
