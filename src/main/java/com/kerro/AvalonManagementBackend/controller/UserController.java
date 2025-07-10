package com.kerro.AvalonManagementBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.kerro.AvalonManagementBackend.dto.LoginRequest;
import com.kerro.AvalonManagementBackend.dto.UserDTO;
import com.kerro.AvalonManagementBackend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.obtenerUsuarios();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.obtenerUsuarioPorId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/crear")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.crearUsuario(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.actualizarUsuario(id, userDTO);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.eliminarUsuario(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        UserDTO user = userService.obtenerUsuarioPorUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getUserByUsernameAndPassword(@RequestBody LoginRequest loginRequest) {
        UserDTO user = userService.obtenerUsuarioPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("User authenticated successfully: " + user.getUsername());
    }

}
