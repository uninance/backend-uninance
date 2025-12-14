package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.CategoryEntity;
import com.uninance.backend.entities.UserEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByUser(UserEntity user);

    List<CategoryEntity> findByUserAndType(UserEntity user, String type);
}
