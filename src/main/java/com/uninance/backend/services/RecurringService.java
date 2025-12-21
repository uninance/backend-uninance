package com.uninance.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import com.uninance.backend.entities.RecurringEntity;

public interface RecurringService {

    RecurringEntity createRecurring(Long userId, RecurringEntity recurring);

    RecurringEntity findById(Long recurringId);

    List<RecurringEntity> findByUser(Long userId);

    List<RecurringEntity> findActiveRecurrings();

    List<RecurringEntity> findDueRecurrings(LocalDateTime now);

    RecurringEntity updateRecurring(Long recurringId, RecurringEntity data);

    void activateRecurring(Long recurringId);

    void deactivateRecurring(Long recurringId);

    void deleteRecurring(Long recurringId);
}