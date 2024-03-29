package com.backend.laundarybackend.controller;

import com.backend.laundarybackend.dto.AdminDto;
import com.backend.laundarybackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")

public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto>saveAdmin(@RequestBody AdminDto adminDto){
        AdminDto savedAdminDto=adminService.saveAdmin(adminDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdminDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteAdmin(@PathVariable String id){
        boolean status=adminService.deleteAdminById(id);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

}
