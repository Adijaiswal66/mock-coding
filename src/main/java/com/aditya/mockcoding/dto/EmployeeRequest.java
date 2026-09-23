package com.aditya.mockcoding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRequest(
        @NotBlank String employeeCode,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email @NotBlank String email,
        @NotBlank String department,
        @NotBlank String designation,
        @NotNull @Positive BigDecimal salary,
        @NotNull LocalDate joiningDate,
        @NotBlank String employmentStatus,
        @NotBlank String location,
        Long managerId
) {}