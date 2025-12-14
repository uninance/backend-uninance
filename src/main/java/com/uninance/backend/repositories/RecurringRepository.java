package com.uninance.backend.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.RecurringEntity;

public interface RecurringRepository extends JpaRepository<RecurringEntity, Long> {

    List<RecurringEntity> findByActiveTrueAndNextExecutionBefore(LocalDateTime now);
}
