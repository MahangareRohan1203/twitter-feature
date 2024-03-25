package com.dice.twitterfeature.exception;

import jakarta.servlet.ServletException;

public class UserException extends ServletException {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
