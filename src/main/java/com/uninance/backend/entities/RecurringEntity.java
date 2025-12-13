package com.uninance.backend.entities;

import java.time.LocalDateTime;

import com.uninance.backend.enums.GitEnum;
import com.uninance.backend.enums.PeriodEnums;

import jakarta.persistence.*;
import lombok.*;

//Clase encargada de manejar los gastos o ingresos que se realizan automaticamente de manera periodica 

@Entity
@Table(name = "recurrings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecurringEntity extends BaseEntity {

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PeriodEnums period;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GitEnum type; 

    @Column(nullable = false)
    private LocalDateTime nextExecution;

    private LocalDateTime endDate;

    //Atributo para manejar si el recurring se ejecuta o no
    @Column(nullable = false)
    private boolean active = true;

    private String description;

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

