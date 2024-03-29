package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.EmployeeSignUpDto;
import com.backend.laundarybackend.entity.Employee;

import java.util.Locale;

public class EmployeeMapper {
    public static Employee MaptoEmployeeEntity(EmployeeSignUpDto employeeSignUpDto){
        return new Employee(
                employeeSignUpDto.getId(),
                employeeSignUpDto.getEmployeeName(),
                employeeSignUpDto.getEmployeePassword(),
                employeeSignUpDto.getPhoneNumber(),
                employeeSignUpDto.getEmailAddress()
        );
    }

    public static EmployeeSignUpDto MaptoEmployeeDto(Employee employee){
        return new EmployeeSignUpDto(
                employee.getId(),
                employee.getEmployeeName(),
                employee.getEmployeePassword(),
                employee.getPhoneNumber(),
                employee.getEmailAddress()
        );
    }
}
