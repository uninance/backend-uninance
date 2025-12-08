package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "goals")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class GoalEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double targetAmount;

    private Double currentAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

