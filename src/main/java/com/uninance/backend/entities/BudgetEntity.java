package com.uninance.backend.entities;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "budgets")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class BudgetEntity extends BaseEntity {

    @Column(nullable = false)
    private Double limitAmount;

    @Column(nullable = false)
    private String period; 

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

