package com.uninance.backend.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Double savingGoal;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column
    private Double earnings;

    @Column
    private String preferences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;   
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CategoryEntity> categories; 
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<IncomeEntity> incomes; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SpentEntity> spents; 

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions; 
}
