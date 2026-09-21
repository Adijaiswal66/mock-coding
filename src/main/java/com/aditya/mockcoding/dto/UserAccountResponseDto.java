package com.aditya.mockcoding.dto;

import com.aditya.mockcoding.entity.Role;

import java.time.Instant;

public record UserAccountResponseDto(
        Long id,
        Long employeeId,
        Role role,
        boolean enabled,
        Instant createdAt,
        Instant updatedAt
) {
}
