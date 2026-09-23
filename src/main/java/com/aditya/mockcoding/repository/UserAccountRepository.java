package com.aditya.mockcoding.repository;

import com.aditya.mockcoding.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository
        extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByEmployeeId(Long employeeId);

}
