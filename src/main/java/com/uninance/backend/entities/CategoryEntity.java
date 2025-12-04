package com.uninance.backend.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends BaseEntity {
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private String icon;

    @Column(nullable = false)
    private boolean userCreated;

    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "category")
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "category")
    private List<SpentEntity> spents;

    @PrePersist
    public void onCreate() {
        this.creationDate = LocalDateTime.now();
    }
}
