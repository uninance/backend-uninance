package com.uninance.backend.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

//entidad encargada de manejar las cuentas del usuario

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double balance;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "account")
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "account")
    private List<SpentEntity> spents;

    @OneToMany(mappedBy = "originAccount")
    private List<TransactionEntity> originTransactions;

    @OneToMany(mappedBy = "destinyAccount")
    private List<TransactionEntity> destinyTransactions;

    @OneToMany(mappedBy = "account")
    private List<RecurringEntity> recurrings;



}
