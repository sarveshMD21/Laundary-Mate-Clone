package com.backend.laundarybackend.service;

import com.backend.laundarybackend.dto.EmployeeLogInDto;
import com.backend.laundarybackend.dto.EmployeeSignUpDto;
import com.backend.laundarybackend.entity.Employee;

public interface EmployeeService {
    EmployeeSignUpDto SignUpEmployee(EmployeeSignUpDto employeeSignUpDto);

    EmployeeSignUpDto LogInEmployee(EmployeeLogInDto employeeLogInDto);

    Employee getEmployeeByUserName(String employeeName);

    boolean DeleteEmployeeByID(String id);

    boolean UpdateEmployee(EmployeeSignUpDto employeeSignUpDto);

    EmployeeSignUpDto getEmployeeByID(String id);
}
