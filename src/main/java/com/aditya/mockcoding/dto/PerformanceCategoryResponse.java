package com.aditya.mockcoding.dto;

import com.aditya.mockcoding.entity.Employee;

import java.util.List;
import java.util.Map;

public record PerformanceCategoryResponse(Map<String, List<Employee>> categories) {
}
