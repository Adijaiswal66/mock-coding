package com.aditya.mockcoding.service;

import com.aditya.mockcoding.dto.AccountActivationRequest;
import com.aditya.mockcoding.dto.LoginRequest;
import com.aditya.mockcoding.dto.LoginResponse;
import com.aditya.mockcoding.dto.UserAccountResponseDto;
import com.aditya.mockcoding.entity.Employee;
import com.aditya.mockcoding.entity.Role;
import com.aditya.mockcoding.entity.UserAccount;
import com.aditya.mockcoding.exception.InvalidCredentialsException;
import com.aditya.mockcoding.exception.UserAccountDisabledException;
import com.aditya.mockcoding.exception.UserAlreadyExistsException;
import com.aditya.mockcoding.exception.UserNotFoundException;
import com.aditya.mockcoding.repository.EmployeeRepository;
import com.aditya.mockcoding.repository.UserAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.expiration}")
    private long expiration;

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
        Optional<Employee> employeeExists = employeeRepository.findByEmployeeCode(accountActivationRequest.employeeCode());
        if (employeeExists.isEmpty()) {
            throw new UserNotFoundException("Employee does not exist");
        }
        Optional<UserAccount> userAccountRepositoryById = userAccountRepository.findByEmployeeId(employeeExists.get().getId());

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

    public LoginResponse loginUser(LoginRequest loginRequest) {
        Optional<Employee> employeeExists = employeeRepository.findByEmployeeCode(loginRequest.employeeCode());
        if (employeeExists.isEmpty()) {
            throw new UserNotFoundException("Employee does not exist");
        }
        Optional<UserAccount> userExists = userAccountRepository.findByEmployeeId(employeeExists.get().getId());

        if (userExists.isEmpty()) {
            throw new UserNotFoundException("User does not exists with this employee code:" + loginRequest.employeeCode());
        }

        if (!userExists.get().isEnabled()) {
            throw new UserAccountDisabledException("User account is disabled!, Please enable it first");
        }

        if (!passwordEncoder.matches(loginRequest.password(), userExists.get().getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        String token = jwtService.generateToken(userExists.get());

        return new LoginResponse(
                token,
                "Bearer",
                expiration / 1000

        );

    }

}
