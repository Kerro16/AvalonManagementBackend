package com.kerro.AvalonManagementBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kerro.AvalonManagementBackend.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    Evento findByNombre(String nombre);
    Optional<Evento> findById(Long id);
    boolean existsByNombre(String nombre);
    boolean existsById(Long id);
    
}
 