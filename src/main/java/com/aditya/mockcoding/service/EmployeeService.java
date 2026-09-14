package com.aditya.mockcoding.service;

import com.aditya.mockcoding.entity.Employee;
import com.aditya.mockcoding.exception.InvalidEmployeeException;
import com.aditya.mockcoding.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new InvalidEmployeeException(
                        "Employee not found with id: " + employeeId));
    }

    public Map<String, List<Employee>> categorizeByPerformance() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new InvalidEmployeeException("No employees found");
        }

        Map<String, List<Employee>> result = new LinkedHashMap<>();

        // Validate first so an invalid record cannot leave a partially-built result.
        for (Employee employee : employees) {
            if (employee.getRating() < 1 || employee.getRating() > 5) {
                throw new InvalidEmployeeException(
                        "Rating should be between 1 and 5 for employee: " + employee.getEmployeeId());
            }
        }

        for (Employee employee : employees) {
            String category = switch (employee.getRating()) {
                case 5 -> "Excellent";
                case 4 -> "Good";
                case 3 -> "Average";
                case 2 -> "Below Average";
                case 1 -> "Poor";
                default -> throw new IllegalStateException("Unexpected rating");
            };

            result.computeIfAbsent(category, key -> new ArrayList<>()).add(employee);
        }

        return result;
    }
}
