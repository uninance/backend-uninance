package com.uninance.backend.repositories;

import com.uninance.backend.entities.NotificationSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationSettingRepository extends JpaRepository<NotificationSettingEntity, Long> {

    List<NotificationSettingEntity> findByUserId(Long userId);

    List<NotificationSettingEntity> findByUserIdAndEnabledTrue(Long userId);
}
