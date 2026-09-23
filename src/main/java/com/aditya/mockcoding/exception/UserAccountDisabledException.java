package com.aditya.mockcoding.exception;

public class UserAccountDisabledException extends RuntimeException {
    public UserAccountDisabledException(String message) {
        super(message);
    }
}
