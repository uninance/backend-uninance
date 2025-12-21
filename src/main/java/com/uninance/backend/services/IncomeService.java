package com.uninance.backend.services;

import java.util.List;

import com.uninance.backend.entities.IncomeEntity;

public interface IncomeService {

    IncomeEntity createIncome(Long userId, Long accountId, Long categoryId, IncomeEntity income);

    IncomeEntity findIncomeById(Long incomeId);

    List<IncomeEntity> findIncomesByUser(Long userId);

    List<IncomeEntity> findIncomesByAccount(Long accountId);

    void deleteIncome(Long incomeId);
}