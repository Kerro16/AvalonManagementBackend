package com.kerro.AvalonManagementBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kerro.AvalonManagementBackend.exception.user.UserAlreadyExistsException;
import com.kerro.AvalonManagementBackend.exception.user.UserException;
import com.kerro.AvalonManagementBackend.exception.user.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado. Por favor, inténtelo de nuevo más tarde.");
    }
        

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La solicitud no pudo ser procesada. Por favor, verifique los datos enviados.");
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya existe. Por favor, elija otro nombre de usuario.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado. Por favor, verifique los datos enviados.");
    }
}
