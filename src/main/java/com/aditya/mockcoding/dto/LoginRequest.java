package com.aditya.mockcoding.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Employee code can not be blank")
        String employeeCode,

        @NotBlank
        String password
) {
}