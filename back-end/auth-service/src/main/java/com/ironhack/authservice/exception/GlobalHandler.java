package com.ironhack.authservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Global Handler of Exceptions
 */
@ControllerAdvice
public class GlobalHandler {
    /**
     * Handler of Exception when User already exists
     * @param e Exception type
     * @param response Response type
     * @throws IOException IOException
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public void handleUserAlreadyExistsException(UserAlreadyExistsException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }
}