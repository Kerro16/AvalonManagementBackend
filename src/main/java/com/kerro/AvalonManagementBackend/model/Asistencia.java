package com.kerro.AvalonManagementBackend.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Asistencia {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Miembros miembro;

    @ManyToOne
    private Evento evento;

    private boolean asistio;

    public Asistencia() {
    }

    public Asistencia(Miembros miembro, Evento evento, boolean asistio) {
        this.miembro = miembro;
        this.evento = evento;
        this.asistio = asistio;
    }

    public Long getId() {
        return id;
    }
    public Miembros getMiembro() {
        return miembro;
    }
    public Evento getEvento() {
        return evento;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setMiembro(Miembros miembro) {
        this.miembro = miembro;
    
    }
    public void setAsistio(boolean asistio) {
        this.asistio = asistio;

    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }


}
