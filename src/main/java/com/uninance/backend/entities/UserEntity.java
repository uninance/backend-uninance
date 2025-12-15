package com.uninance.backend.entities;

import java.util.List;

import com.uninance.backend.enums.RoleEnum;

import jakarta.persistence.*;
import lombok.*;

//Clase encargada de manejar la entidad de usuario
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
  
    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum role;

    @Column(nullable = false, unique = true)
    private boolean active = true;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;

    //atributo para manejar ganancias periodicas
    @Column
    private Double earnings;

    //Configuraciones del usuario
    @Column
    private String preferences;

    //metas de ahorro del usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GoalEntity> goals;

    //Cuentas asociadas al usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;   
    
    //categorias asociadas al usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CategoryEntity> categories; 
    
    //GITS
    //ganancias del usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<IncomeEntity> incomes; 

    //gastos del usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SpentEntity> spents; 

    //transacciones del usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions; 

    //Presupuestos creados por el usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BudgetEntity> budgets; 

    //GITs recurrentes del usuario
    @OneToMany(mappedBy = "user")
    private List<RecurringEntity> recurrings;

    //Notificaciones del usuario
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationEntity> notifications;

    //Configuracion de notificaciones
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationSettingEntity> notificationSettings;


}
