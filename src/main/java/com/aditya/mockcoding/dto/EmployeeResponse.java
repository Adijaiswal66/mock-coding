package com.aditya.mockcoding.dto;

public record EmployeeResponse(
        Long employeeId,
        String employeeName,
        double salary,
        int rating,
        String department,
        int yearsOfExperience
) {
}
