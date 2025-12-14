package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.SpentEntity;
import com.uninance.backend.entities.UserEntity;

public interface SpentRepository extends JpaRepository<SpentEntity, Long> {

    List<SpentEntity> findByUser(UserEntity user);
}
