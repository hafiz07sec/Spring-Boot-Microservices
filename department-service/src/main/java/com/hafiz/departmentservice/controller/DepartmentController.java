package com.hafiz.departmentservice.controller;

import com.hafiz.departmentservice.dto.DepartmentDto;
import com.hafiz.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Save department REST API
    @Operation(
            summary = "Save Department REST APIs",
            description = "Save Department REST APIs is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/")
    public ResponseEntity<DepartmentDto> saveDepartment( @RequestBody  DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //Build get department REST API
    @Operation(
            summary = "GET Department REST APIs",
            description = "Get Department REST APIs is used to get department object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }


}
