package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;

//Clase padre de los GIT

@MappedSuperclass
@Getter
@Setter
public class GITEntity extends BaseEntity {

    @Column(nullable = false)
    private Double amount;

    @Column
    private String description; 

}


