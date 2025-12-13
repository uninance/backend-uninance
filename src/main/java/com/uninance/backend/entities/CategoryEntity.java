package com.uninance.backend.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

//entidad encargada de manejar las categorias de la aplicacion

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends BaseEntity {
    
    @Column(nullable = false)
    private String name;

    //Spent o Income, atributo para facilitar filtrado y clasificacion
    @Column(nullable = false)
    private String type;

    private String icon;

    @Column(nullable = false)
    private boolean userCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "category")
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "category")
    private List<SpentEntity> spents;

    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private BudgetEntity budget;

    @OneToMany(mappedBy = "category")
    private List<RecurringEntity> recurrings;


}
