package com.uninance.backend.entities;

import com.uninance.backend.enums.PeriodEnums;
import jakarta.persistence.*;
import lombok.*;

//Clase que sirve para manejar los limites de gasto mensuales, se maneja con las categorias y alertas

@Entity
@Table(name = "budgets")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class BudgetEntity extends BaseEntity {

    @Column(nullable = false)
    private Double limitAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PeriodEnums period;

    //categoria a la que esta asociado el presupuesto
    @OneToOne
    @JoinColumn(name = "category_id", unique = true)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    
}

