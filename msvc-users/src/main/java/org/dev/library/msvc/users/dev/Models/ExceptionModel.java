package org.dev.library.msvc.users.dev.Models;

import org.springframework.http.HttpStatus;


public class ExceptionModel {

    private HttpStatus status;
    private String message;
    private String details;

    public ExceptionModel(HttpStatus status, String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
