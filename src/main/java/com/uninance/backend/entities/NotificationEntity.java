package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class NotificationEntity extends BaseEntity {

    @Column(nullable = false)
    private String message;

    private boolean read;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

