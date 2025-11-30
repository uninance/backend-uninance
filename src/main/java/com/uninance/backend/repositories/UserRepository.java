package com.uninance.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uninance.backend.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
