package com.aditya.mockcoding.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        String location
) {
}