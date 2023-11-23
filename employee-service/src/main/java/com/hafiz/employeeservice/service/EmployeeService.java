package com.hafiz.employeeservice.service;

import com.hafiz.employeeservice.dto.APIResponseDto;
import com.hafiz.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
