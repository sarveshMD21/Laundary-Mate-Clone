package com.backend.laundarybackend.repository;

import com.backend.laundarybackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Employee a WHERE a.employeeName = :employeeName")
    boolean existsByEmployeeName(String employeeName);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Employee a WHERE a.phoneNumber = :phoneNumber")
    boolean existsByPhoneNumber(String phoneNumber);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Employee a WHERE a.emailAddress = :emailAddress")
    boolean existsByEmailAddress(String emailAddress);

    @Query("SELECT e FROM Employee e WHERE e.employeeName=:employeeName")
    Optional<Employee> findByEmployeeName(String employeeName);
}
