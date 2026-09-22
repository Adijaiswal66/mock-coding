package com.aditya.mockcoding.service;

import com.aditya.mockcoding.dto.AccountActivationRequest;
import com.aditya.mockcoding.dto.UserAccountResponseDto;
import com.aditya.mockcoding.entity.Employee;
import com.aditya.mockcoding.entity.Role;
import com.aditya.mockcoding.entity.UserAccount;
import com.aditya.mockcoding.exception.UserAlreadyExistsException;
import com.aditya.mockcoding.repository.EmployeeRepository;
import com.aditya.mockcoding.repository.UserAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserAccountResponseDto toDto(UserAccount userAccount) {
        return new UserAccountResponseDto(
                userAccount.getId(),
                userAccount.getEmployee().getId(),
                userAccount.getRole(),
                userAccount.isEnabled(),
                userAccount.getCreatedAt(),
                userAccount.getUpdatedAt()
        );
    }

    @Transactional
    public String registerUser(AccountActivationRequest accountActivationRequest) {
        Optional<Employee> employeeExists = employeeRepository.findById(accountActivationRequest.employeeId());
        if (employeeExists.isEmpty()) {
            throw new NoSuchElementException();
        }

        Optional<UserAccount> userAccountRepositoryById = userAccountRepository.findByEmployeeId(accountActivationRequest.employeeId());

        if (userAccountRepositoryById.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setRole(Role.EMPLOYEE);
        userAccount.setEmployee(employeeExists.get());
        userAccount.setEnabled(true);
        userAccount.setCreatedAt(Instant.now());
        userAccount.setUpdatedAt(Instant.now());
        userAccount.setPasswordHash(passwordEncoder.encode(accountActivationRequest.password()));

        userAccountRepository.save(userAccount);

        return "User registered successfully";

    }

}
