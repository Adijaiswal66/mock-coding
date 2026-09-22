package com.aditya.mockcoding.controller;

import com.aditya.mockcoding.dto.AccountActivationRequest;
import com.aditya.mockcoding.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid AccountActivationRequest accountActivationRequest) {
        System.out.println(accountActivationRequest);
        String registerUser = userService.registerUser(accountActivationRequest);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

}
