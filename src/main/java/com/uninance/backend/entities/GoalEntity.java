package com.uninance.backend.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

//Clase encargada del manejo de metas de ahorro del usuario

@Entity
@Table(name = "goals")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class GoalEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    //meta de ahorro
    @Column(nullable = false)
    private Double targetAmount;

    // valor actual
    @Column(nullable = false)
    private Double currentAmount;

    //Tiene deadline = true | no tiene deadline = false
    @Column(nullable = false)
    private boolean deadlineGoal;
    
    //atributo para manejar la fecha limite
    @Column
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

