package com.backend.laundarybackend.ServiceImpl;
import com.backend.laundarybackend.entity.Admin;

import com.backend.laundarybackend.dto.AdminDto;
import com.backend.laundarybackend.exception.DuplicateEntityException;
import com.backend.laundarybackend.mapper.AdminMapper;
import com.backend.laundarybackend.repository.AdminRepository;
import com.backend.laundarybackend.service.AdminService;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AdminDto saveAdmin(AdminDto adminDto)  {
        String adminName=adminDto.getAdminName();
        String hashedPassword=passwordEncoder.encode(adminDto.getAdminPassword());
        if(adminRepository.existsByUsername(adminName)){
            throw new DuplicateEntityException("The username already exisit");
        }
        adminDto.setAdminPassword(hashedPassword);
        Admin savedAdmin=adminRepository.save(AdminMapper.mapToAdminEntity(adminDto));
        return AdminMapper.maptoAdminDto(savedAdmin);
    }

    @Override
    public boolean deleteAdminById(String id){
        if(adminRepository.existsById(UUID.fromString(id))){
            adminRepository.deleteById(UUID.fromString(id));
            return true;
        }
        else{
            return false;
        }
    }

}
