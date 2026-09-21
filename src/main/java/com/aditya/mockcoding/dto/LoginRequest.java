package com.aditya.mockcoding.dto;

public record LoginRequest(
        Long employeeId,
        String password
) {}