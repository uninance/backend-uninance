package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;

//Clase encargada de manejar los ingresos del usuario

@Entity
@Table(name = "incomes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class IncomeEntity extends GITEntity{

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