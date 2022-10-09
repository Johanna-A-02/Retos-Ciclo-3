package com.reto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "adminUser")
public class AdminUser {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdminUser;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
}
