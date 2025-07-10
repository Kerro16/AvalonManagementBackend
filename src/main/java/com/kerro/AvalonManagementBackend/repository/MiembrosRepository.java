package com.kerro.AvalonManagementBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kerro.AvalonManagementBackend.model.Miembros;

@Repository
public interface MiembrosRepository extends JpaRepository<Miembros, Long> { 

    Miembros findByAccount(String account);
    Optional<Miembros> findById(Long id);
    boolean existsByAccount(String account);
    boolean existsById(Long id);
}
