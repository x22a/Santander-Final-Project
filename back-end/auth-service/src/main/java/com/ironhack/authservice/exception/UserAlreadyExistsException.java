package com.ironhack.authservice.exception;


/**
 * Exception when User already exists
 */
public class UserAlreadyExistsException extends RuntimeException {
    /**
     * Constructor for Exception
     * @param message String message
     */
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
