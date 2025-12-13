package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;

//Clase encargada de manejar los gastos

@Entity
@Table(name = "spents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SpentEntity extends GITEntity{

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