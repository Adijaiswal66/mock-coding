package com.aditya.mockcoding.dto;

public record LoginResponse(
        String accessToken,
        String tokenType,
        long expiresIn
) {}
