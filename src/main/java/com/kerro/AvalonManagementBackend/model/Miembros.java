package com.kerro.AvalonManagementBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Miembros {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private boolean isActive;
    private Roles role;

    public Miembros() {
    }

    public Miembros(String account, boolean isActive, Roles role) {
        this.account = account;
        this.isActive = isActive;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

}