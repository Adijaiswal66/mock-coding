package com.aditya.mockcoding.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmployeeResponseDto(
        Long id,
        String employeeCode,
        String firstName,
        String lastName,
        String email,
        String department,
        String designation,
        BigDecimal salary,
        LocalDate joiningDate,
        String employmentStatus,
        String location,
        Long managerId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long version
) {
}