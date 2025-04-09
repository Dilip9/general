package com.gouri.general.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus status;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
