package com.aditya.mockcoding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private Instant timestamp;
    private int status;
    private String message;
    private Map<String, String> errors;

}
