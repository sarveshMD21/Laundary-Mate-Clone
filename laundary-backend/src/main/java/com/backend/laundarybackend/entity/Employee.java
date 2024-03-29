package com.backend.laundarybackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="employee_name")
    private String employeeName;
    @Column(name="employee_password")
    private String employeePassword;
    @Column(name="employee_number")
    private String phoneNumber;
    @Column(name="employee_address")
    private String emailAddress;
}
