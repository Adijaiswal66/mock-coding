package com.aditya.mockcoding.dto;

public record AccountActivationRequest(
        Long employeeId,
        String password
) {}
