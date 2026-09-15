package com.aditya.mockcoding.controller;

import com.aditya.mockcoding.dto.EmployeePageResponseDto;
import com.aditya.mockcoding.dto.EmployeeResponseDto;
import com.aditya.mockcoding.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all-employees")
    public List<EmployeeResponseDto> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/all-emp")
    public ResponseEntity<EmployeePageResponseDto> getEmployees(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(employeeService.getEmployees(page, size));
    }

}