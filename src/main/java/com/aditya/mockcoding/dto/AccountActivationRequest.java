package com.aditya.mockcoding.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AccountActivationRequest(

        @NotBlank(message = "Employee code can not be blank")
        String employeeCode,

        @NotNull(message = "Password can not be null")
        @NotBlank(message = "Password can not be blank")
        String password
) {
}
