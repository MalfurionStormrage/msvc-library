package org.dev.library.msvc.users.dev.Exceptions;

import org.dev.library.msvc.users.dev.Models.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionModel> GlobalExceptionHandler(Exception ex, WebRequest resquest) {
        ExceptionModel exceptionModel = new ExceptionModel(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                resquest.getDescription(false));
        return new ResponseEntity<>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
