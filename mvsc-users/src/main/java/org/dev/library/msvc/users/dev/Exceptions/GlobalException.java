package org.dev.library.msvc.users.dev.Exceptions;

import org.dev.library.msvc.users.dev.Models.UsersErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException extends RuntimeException {

    /*Manejo de exceptions globales*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<UsersErros> GlobalExceptionHandler(Exception ex, WebRequest resquest) {
        UsersErros usersErros = new UsersErros(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                resquest.getDescription(false));
        return new ResponseEntity<>(usersErros, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
