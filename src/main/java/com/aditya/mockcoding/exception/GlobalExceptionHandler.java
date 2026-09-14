package com.aditya.mockcoding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleInvalidEmployee(InvalidEmployeeException exception) {
        return Map.of(
                "timestamp", Instant.now(),
                "status", 400,
                "error", "Bad Request",
                "message", exception.getMessage()
        );
    }
}
