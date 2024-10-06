package org.dev.library.msvc.users.dev.Models;

public class UserResponse {
    private String message;
    private boolean success;

    public UserResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
