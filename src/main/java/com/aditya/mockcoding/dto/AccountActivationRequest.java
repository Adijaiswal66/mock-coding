package com.aditya.mockcoding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AccountActivationRequest(

        @NotNull(message = "Employee id can not be null")
        @Positive(message = "Employee id must be a positive whole number")
        Long employeeId,

        @NotNull(message = "Password can not be null")
        @NotBlank(message = "Password can not be blank")
        String password
) {
}
