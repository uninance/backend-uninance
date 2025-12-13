package com.uninance.backend.entities;

import java.time.LocalTime;

import com.uninance.backend.enums.PeriodEnums;
import com.uninance.backend.enums.NotificationType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notification_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSettingEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PeriodEnums frequency;

    @Column(nullable = false)
    private boolean enabled = true;

    private LocalTime preferredTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
