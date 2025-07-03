package com.kerro.AvalonManagementBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class miembros {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private boolean isActive;
    private roles role;

    public miembros() {
    }

    public miembros(String account, boolean isActive, roles role) {
        this.account = account;
        this.isActive = isActive;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

}