package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.dto.EmployeeLogInDto;
import com.backend.laundarybackend.dto.EmployeeSignUpDto;
import com.backend.laundarybackend.entity.Employee;
import com.backend.laundarybackend.mapper.EmployeeMapper;
import com.backend.laundarybackend.repository.EmployeeRepository;
import com.backend.laundarybackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public EmployeeSignUpDto SignUpEmployee(EmployeeSignUpDto employeeSignUpDto) {
        if(employeeRepository.existsByEmployeeName(employeeSignUpDto.getEmployeeName())){
            throw new RuntimeException("User name already exists");
        }
        else if(employeeRepository.existsByPhoneNumber(employeeSignUpDto.getPhoneNumber())){
            throw new RuntimeException("Phone number already exists");
        }
        else if(employeeRepository.existsByEmailAddress(employeeSignUpDto.getEmailAddress())){
            throw new RuntimeException("Email Address already exists");
        }
        String haspassword=passwordEncoder.encode(employeeSignUpDto.getEmployeePassword());
        employeeSignUpDto.setEmployeePassword(haspassword);
        Employee savedEmployee=employeeRepository.save(EmployeeMapper.MaptoEmployeeEntity(employeeSignUpDto));
        return EmployeeMapper.MaptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeSignUpDto LogInEmployee(EmployeeLogInDto employeeLogInDto) {
        if(!employeeRepository.existsByEmployeeName(employeeLogInDto.getEmployeeName())){
            throw new RuntimeException("User name does not exists");
        }
        Employee employee=getEmployeeByUserName(employeeLogInDto.getEmployeeName());
        if(!passwordEncoder.matches(employeeLogInDto.getEmployeePassword(),employee.getEmployeePassword())){
            throw new RuntimeException("Password does not match");
        }
        return EmployeeMapper.MaptoEmployeeDto(employee);
    }

    @Override
    public Employee getEmployeeByUserName(String employeeName) {
        Optional<Employee>optionalEmployee=employeeRepository.findByEmployeeName(employeeName);
        return optionalEmployee.orElse(null);
    }

    @Override
    public boolean DeleteEmployeeByID(String id) {
        if(employeeRepository.existsById(UUID.fromString(id))){
            employeeRepository.deleteById(UUID.fromString(id));
            return true;
        }
        else{
            return  false;
        }
    }

    @Override
    public boolean UpdateEmployee(EmployeeSignUpDto employeeSignUpDto) {
        if(employeeRepository.existsById(employeeSignUpDto.getId())){
            Employee employee=EmployeeMapper.MaptoEmployeeEntity(employeeSignUpDto);
            employeeRepository.save(employee);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public EmployeeSignUpDto getEmployeeByID(String id) {
        if(employeeRepository.existsById(UUID.fromString(id))){
            Optional<Employee>employeeOptional=employeeRepository.findById(UUID.fromString(id));
            return EmployeeMapper.MaptoEmployeeDto(employeeOptional.get());
        }
        return null;
    }


}
