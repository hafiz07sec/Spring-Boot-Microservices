package com.hafiz.departmentservice.mapper;

import com.hafiz.departmentservice.dto.DepartmentDto;
import com.hafiz.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {


    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
