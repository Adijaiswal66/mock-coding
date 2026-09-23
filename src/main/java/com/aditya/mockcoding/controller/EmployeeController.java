package com.aditya.mockcoding.controller;

import com.aditya.mockcoding.dto.*;
import com.aditya.mockcoding.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<EmployeePageResponseDto> getEmployees(@Valid @ModelAttribute PaginationRequest paginationRequest) {
        return ResponseEntity.ok(employeeService.getEmployees(paginationRequest.getPage(), paginationRequest.getSize()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeUpdateRequest request) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}