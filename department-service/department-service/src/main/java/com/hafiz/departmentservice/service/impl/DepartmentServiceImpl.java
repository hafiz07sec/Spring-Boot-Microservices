package com.hafiz.departmentservice.service.impl;

import com.hafiz.departmentservice.dto.DepartmentDto;
import com.hafiz.departmentservice.entity.Department;
import com.hafiz.departmentservice.exception.DepartmentAlreadyExistException;
import com.hafiz.departmentservice.exception.ResourceNotFoundException;
import com.hafiz.departmentservice.mapper.DepartmentMapper;
import com.hafiz.departmentservice.repository.DepartmentRepository;
import com.hafiz.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        String departmentCode = departmentDto.getDepartmentCode();
        Department existingDepartment = departmentRepository.findByDepartmentCode(departmentCode);

        if (existingDepartment != null) {
            // Handle the case where the department already exists
            throw new DepartmentAlreadyExistException("Department with code " + departmentCode + " already exists.");
        }
        //convert department dto to department jpa entity

        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);


        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department= departmentRepository.findByDepartmentCode(departmentCode);
        if (department == null){
            throw new ResourceNotFoundException("Department", " code: ",  departmentCode);
        }
        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
