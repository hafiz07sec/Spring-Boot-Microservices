package com.hafiz.employeeservice.mapper;

import com.hafiz.employeeservice.dto.EmployeeDto;
import com.hafiz.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDto employeeDto);
//public static EmployeeDto mapToEmployeeDto(Employee employee){
//    EmployeeDto employeeDto = new EmployeeDto(
//            employee.getId(),
//            employee.getFirstName(),
//            employee.getLastName(),
//            employee.getEmail(),
//            employee.getDepartmentCode()
//    );
//    return employeeDto;
//}
//
//    public static Employee mapToEmployee(EmployeeDto employeeDto){
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail(),
//                employeeDto.getDepartmentCode()
//        );
//        return employee;
//    }
}
