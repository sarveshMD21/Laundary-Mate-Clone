package com.backend.laundarybackend.controller;

import com.backend.laundarybackend.dto.EmployeeLogInDto;
import com.backend.laundarybackend.dto.EmployeeSignUpDto;
import com.backend.laundarybackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<EmployeeSignUpDto> addEmployee(@RequestBody EmployeeSignUpDto employeeSignUpDto){
        EmployeeSignUpDto savedEmployee=employeeService.SignUpEmployee(employeeSignUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PostMapping("/login")
    public ResponseEntity<UUID>LogInEmployee(@RequestBody EmployeeLogInDto employeeLogInDto){
        EmployeeSignUpDto loggedEmployee=employeeService.LogInEmployee(employeeLogInDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedEmployee.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteEmployee(@PathVariable String id){
        boolean status=employeeService.DeleteEmployeeByID(id);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean>updateEmployee(@RequestBody EmployeeSignUpDto employeeSignUpDto){
        boolean status=employeeService.UpdateEmployee(employeeSignUpDto);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSignUpDto>getEmployeeById(@PathVariable String id){
        EmployeeSignUpDto employeeSignUpDto=employeeService.getEmployeeByID(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeSignUpDto);
    }
}
