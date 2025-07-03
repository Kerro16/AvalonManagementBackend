package com.kerro.AvalonManagementBackend.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class asistencia {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private miembros miembro;

    @ManyToOne
    private evento evento;

    private boolean asistio;

    public asistencia() {
    }

    public asistencia(miembros miembro, evento evento, boolean asistio) {
        this.miembro = miembro;
        this.evento = evento;
        this.asistio = asistio;
    }

    public Long getId() {
        return id;
    }
    public miembros getMiembro() {
        return miembro;
    }
    public evento getEvento() {
        return evento;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setMiembro(miembros miembro) {
        this.miembro = miembro;
    
    }
    public void setAsistio(boolean asistio) {
        this.asistio = asistio;

    }
    public void setEvento(evento evento) {
        this.evento = evento;
    }


}
