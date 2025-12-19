package com.uninance.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uninance.backend.entities.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByUserId(Long userId);

}
