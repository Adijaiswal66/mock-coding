package com.aditya.mockcoding.repository;

import com.aditya.mockcoding.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();

    Optional<Employee> findById(Long employeeId);
}
