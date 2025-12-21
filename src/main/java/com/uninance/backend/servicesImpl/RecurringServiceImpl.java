package com.uninance.backend.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uninance.backend.entities.RecurringEntity;
import com.uninance.backend.entities.UserEntity;
import com.uninance.backend.repositories.RecurringRepository;
import com.uninance.backend.services.RecurringService;
import com.uninance.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecurringServiceImpl implements RecurringService {

    private final RecurringRepository recurringRepository;
    private final UserService userService;

    @Override
    public RecurringEntity createRecurring(Long userId, RecurringEntity recurring) {
        UserEntity user = userService.findUserById(userId);
        recurring.setUser(user);
        recurring.setActive(true);
        return recurringRepository.save(recurring);
    }

    @Override
    public RecurringEntity findById(Long recurringId) {
        return recurringRepository.findById(recurringId)
                .orElseThrow(() -> new RuntimeException("Recurring not found"));
    }

    @Override
    public List<RecurringEntity> findByUser(Long userId) {
        return recurringRepository.findByUserId(userId);
    }

    @Override
    public List<RecurringEntity> findActiveRecurrings() {
        return recurringRepository.findByActiveTrue();
    }

    @Override
    public List<RecurringEntity> findDueRecurrings(LocalDateTime now) {
        return recurringRepository.findByActiveTrueAndNextExecutionBefore(now);
    }

    @Override
    public RecurringEntity updateRecurring(Long recurringId, RecurringEntity data) {
        RecurringEntity existing = findById(recurringId);

        if (data.getAmount() != null) {
            existing.setAmount(data.getAmount());
        }
        if (data.getPeriod() != null) {
            existing.setPeriod(data.getPeriod());
        }
        if (data.getType() != null) {
            existing.setType(data.getType());
        }
        if (data.getNextExecution() != null) {
            existing.setNextExecution(data.getNextExecution());
        }
        if (data.getEndDate() != null) {
            existing.setEndDate(data.getEndDate());
        }
        if (data.getDescription() != null) {
            existing.setDescription(data.getDescription());
        }
        if (data.getCategory() != null) {
            existing.setCategory(data.getCategory());
        }
        if (data.getAccount() != null) {
            existing.setAccount(data.getAccount());
        }

        return recurringRepository.save(existing);
    }

    @Override
    public void activateRecurring(Long recurringId) {
        RecurringEntity recurring = findById(recurringId);
        recurring.setActive(true);
        recurringRepository.save(recurring);
    }

    @Override
    public void deactivateRecurring(Long recurringId) {
        RecurringEntity recurring = findById(recurringId);
        recurring.setActive(false);
        recurringRepository.save(recurring);
    }

    @Override
    public void deleteRecurring(Long recurringId) {
        if (!recurringRepository.existsById(recurringId)) {
            throw new RuntimeException("Recurring not found");
        }
        recurringRepository.deleteById(recurringId);
    }
}