package com.aditya.mockcoding.service;

import com.aditya.mockcoding.dto.EmployeePageResponseDto;
import com.aditya.mockcoding.dto.EmployeeResponseDto;
import com.aditya.mockcoding.entity.Employee;
import com.aditya.mockcoding.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponseDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(this::toDto)
                .toList();
    }

    private EmployeeResponseDto toDto(Employee employee) {
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getEmployeeCode(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getJoiningDate(),
                employee.getEmploymentStatus(),
                employee.getLocation()
        );
    }

    public EmployeePageResponseDto getEmployees(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Employee> employees = employeeRepository.findAll(pageable);

        EmployeePageResponseDto employeePageResponseDto = new EmployeePageResponseDto();
        employeePageResponseDto.setEmployeeResponseDto(employees.getContent().stream().map(this::toDto).toList());
        employeePageResponseDto.setPageNumber(employees.getPageable().getPageNumber());
        employeePageResponseDto.setPageSize(employees.getPageable().getPageSize());
        employeePageResponseDto.setLast(employees.isLast());
        employeePageResponseDto.setTotalPages(employees.getTotalPages());
        employeePageResponseDto.setFirst(employees.isFirst());
        employeePageResponseDto.setTotalElements(employees.getTotalElements());

        return employeePageResponseDto;
    }
}