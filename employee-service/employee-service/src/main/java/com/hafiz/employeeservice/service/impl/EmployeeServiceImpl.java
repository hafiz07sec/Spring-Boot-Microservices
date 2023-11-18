package com.hafiz.employeeservice.service.impl;

import com.hafiz.employeeservice.dto.APIResponseDto;
import com.hafiz.employeeservice.dto.DepartmentDto;
import com.hafiz.employeeservice.dto.EmployeeDto;
import com.hafiz.employeeservice.entity.Employee;
import com.hafiz.employeeservice.exception.EmailAlreadyExistException;
import com.hafiz.employeeservice.exception.ResourceNotFoundException;
import com.hafiz.employeeservice.mapper.EmployeeMapper;
import com.hafiz.employeeservice.repository.EmployeeRepository;
import com.hafiz.employeeservice.service.APIClient;
import com.hafiz.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee= employeeRepository.findByEmail(employeeDto.getEmail());
        if(optionalEmployee.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exists for Employee");
        }

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
//        Employee employee=employeeRepository.findById(employeeId).get();
//
//        EmployeeDto employeeDto=EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
//        return employeeDto;
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isEmpty()) {
            throw new ResourceNotFoundException("Employee ", " ID: " , employeeId);
        }

        Employee employee = employeeOptional.get();

        //REST template for REST API CALL btn microservice
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        //WebClient for REST API CALL btn microservices
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+ employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        //spring-cloud-openFeign library to REST API CALL btn microservices
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
