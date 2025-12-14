package com.uninance.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uninance.backend.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Buscar usuario por email (login)
    Optional<UserEntity> findByEmail(String email);

    // Verificar si ya existe un email
    boolean existsByEmail(String email);
}
