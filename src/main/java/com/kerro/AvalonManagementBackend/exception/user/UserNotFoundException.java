package com.kerro.AvalonManagementBackend.exception.user;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(Long id) {
        super(id != null ? "User con ID " + id + " no encontrado." : "Usuario no encontrado.");
    }

    public UserNotFoundException(String username) {
        super(username != null ? "Usuario con username '" + username + "' no encontrado." : "Usuario no encontrado.");
    }
}