package com.aditya.mockcoding.exception;

import com.aditya.mockcoding.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidEmployee(InvalidEmployeeException exception) {
        return new ErrorResponse(
                Instant.now(),
                400,
                exception.getMessage(),
                null
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
        for (FieldError error : fieldError) {
            if (error.isBindingFailure()) {
                errors.put(error.getField(), "Please enter a valid integer");
            } else {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        }
        return new ErrorResponse(Instant.now(), 400, "Please enter a valid input", errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotAvailable(HttpMessageNotReadableException exception) {
        return new ErrorResponse(Instant.now(), 400, "Invalid input format. Please ensure to enter whole numbers", null);
    }

    @ExceptionHandler(InvalidPaginationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidPaginationException(InvalidPaginationException exception) {
        return new ErrorResponse(Instant.now(), 400, exception.getMessage(), null);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(NoSuchElementException exception) {
        return new ErrorResponse(Instant.now(), 404, "User does not exist", null);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return new ErrorResponse(Instant.now(), 208, exception.getMessage(), null);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEmployeeNotFoundException(UserNotFoundException exception) {
        return new ErrorResponse(Instant.now(),404, exception.getMessage(), null);
    }
}