package org.dev.library.msvc.users.dev.Models;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UsersErros {

    private HttpStatus status;
    private String message;
    private String details;

    public UsersErros(HttpStatus status, String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
