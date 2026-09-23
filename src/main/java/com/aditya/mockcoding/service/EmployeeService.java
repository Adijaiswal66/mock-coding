package com.aditya.mockcoding.service;

import com.aditya.mockcoding.dto.EmployeePageResponseDto;
import com.aditya.mockcoding.dto.EmployeeRequest;
import com.aditya.mockcoding.dto.EmployeeResponseDto;
import com.aditya.mockcoding.dto.EmployeeUpdateRequest;
import com.aditya.mockcoding.entity.Employee;
import com.aditya.mockcoding.exception.EmployeeVersionConflictException;
import com.aditya.mockcoding.exception.InvalidPaginationException;
import com.aditya.mockcoding.exception.UserAlreadyExistsException;
import com.aditya.mockcoding.exception.UserNotFoundException;
import com.aditya.mockcoding.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
                employee.getLocation(),
                employee.getManagerId(),
                employee.getCreatedAt(),
                employee.getUpdatedAt(),
                employee.getVersion()
        );
    }

    @Transactional
    public EmployeeResponseDto createEmployee(EmployeeRequest request) {

        if (employeeRepository.existsByEmployeeCode(request.employeeCode())) {
            throw new UserAlreadyExistsException("Employee code already exists");
        }

        if (employeeRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        Employee employee = new Employee();

        employee.setEmployeeCode(request.employeeCode());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setDepartment(request.department());
        employee.setDesignation(request.designation());
        employee.setSalary(request.salary());
        employee.setJoiningDate(request.joiningDate());
        employee.setEmploymentStatus(request.employmentStatus());
        employee.setLocation(request.location());
        employee.setManagerId(request.managerId());

        LocalDateTime now = LocalDateTime.now();
        employee.setCreatedAt(now);
        employee.setUpdatedAt(now);

        return toDto(employeeRepository.save(employee));
    }

    public EmployeePageResponseDto getEmployees(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeeRepository.findAll(pageable);

        if (page >= employees.getTotalPages()) {
            throw new InvalidPaginationException("Requested page is not available");
        }
        EmployeePageResponseDto employeePageResponseDto = new EmployeePageResponseDto();

        employeePageResponseDto.setEmployeeResponseDto(employees.getContent().stream().map(this::toDto).toList());
        employeePageResponseDto.setPageNumber(employees.getNumber());
        employeePageResponseDto.setPageSize(employees.getSize());
        employeePageResponseDto.setLast(employees.isLast());
        employeePageResponseDto.setTotalPages(employees.getTotalPages());
        employeePageResponseDto.setFirst(employees.isFirst());
        employeePageResponseDto.setTotalElements(employees.getTotalElements());

        return employeePageResponseDto;
    }

    @Transactional(readOnly = true)
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found"));

        return toDto(employee);
    }

    @Transactional
    public EmployeeResponseDto updateEmployee(Long id, EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("Employee not found"));

        employee.setEmployeeCode(request.employeeCode());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setDepartment(request.department());
        employee.setDesignation(request.designation());
        employee.setSalary(request.salary());
        employee.setJoiningDate(request.joiningDate());
        employee.setEmploymentStatus(request.employmentStatus());
        employee.setLocation(request.location());
        employee.setManagerId(request.managerId());

        employee.setUpdatedAt(LocalDateTime.now());

        return toDto(employeeRepository.save(employee));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }

}