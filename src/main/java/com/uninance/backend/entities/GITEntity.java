package com.uninance.backend.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public class GITEntity extends BaseEntity {

    @Column(nullable = false)
    private Double amount;

    @Column
    private String description; 

    @Column
    private LocalDateTime date; 

    @PrePersist
    public void onGitCreate() {
        this.date = LocalDateTime.now();
    }

    
}


