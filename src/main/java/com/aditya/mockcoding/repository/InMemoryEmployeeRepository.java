package com.aditya.mockcoding.repository;

import com.aditya.mockcoding.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1L, "Aditya", 600000, 4, "IT", 4),
            new Employee(2L, "Rahul", 450000, 5, "HR", 6),
            new Employee(3L, "Priya", 800000, 3, "IT", 3),
            new Employee(4L, "Amit", 300000, 2, "Finance", 2),
            new Employee(5L, "Sneha", 1000000, 5, "IT", 7)
    ));

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees);
    }

    @Override
    public Optional<Employee> findById(Long employeeId) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst();
    }
}
