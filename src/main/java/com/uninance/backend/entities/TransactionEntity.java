package com.uninance.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TransactionEntity extends GITEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "origin_account_id")
    private AccountEntity originAccount;

    @ManyToOne
    @JoinColumn(name = "destiny_account_id")
    private AccountEntity destinyAccount; 
}