package org.dev.library.msvc.users.dev.Models;

import lombok.Data;

@Data
public class UserResponse {
    private String message;
    private boolean success;

    public UserResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
