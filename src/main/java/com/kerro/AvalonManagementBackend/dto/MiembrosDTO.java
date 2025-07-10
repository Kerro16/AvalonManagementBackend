package com.kerro.AvalonManagementBackend.dto;

public class MiembrosDTO {
    private Long id;
    private String account;
    private boolean isActive;
    private String role;

    public MiembrosDTO() {
    }

    public MiembrosDTO(Long id, String account, boolean isActive, String role) {
        this.id = id;
        this.account = account;
        this.isActive = isActive;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "miembrosDTO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", isActive=" + isActive +
                ", role='" + role + '\'' +
                '}';    
    }
}