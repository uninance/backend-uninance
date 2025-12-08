package com.uninance.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recurrings")
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class RecurringEntity extends BaseEntity {

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String frequency; // DAILY, WEEKLY, MONTHLY, YEARLY

    @Column(nullable = false)
    private LocalDateTime nextExecution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
}
