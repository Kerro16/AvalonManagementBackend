package com.kerro.AvalonManagementBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kerro.AvalonManagementBackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    User findByNombre(String nombre);
    Optional<User> findById(Long id);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);
    boolean existsByNombre(String nombre);

    
}
