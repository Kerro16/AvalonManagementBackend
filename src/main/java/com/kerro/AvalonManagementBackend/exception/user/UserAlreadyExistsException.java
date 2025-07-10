package com.kerro.AvalonManagementBackend.exception.user;

public class UserAlreadyExistsException extends UserException {

    public UserAlreadyExistsException(String username) {
        super("User con username '" + username + "' ya existe.");
    }
}
