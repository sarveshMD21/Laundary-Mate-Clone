package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.AdminDto;
import com.backend.laundarybackend.entity.Admin;

public class AdminMapper {

    public static Admin mapToAdminEntity(AdminDto adminDto){
        return new Admin(adminDto.getId(), adminDto.getAdminName(), adminDto.getAdminPassword());
    }

    public static AdminDto maptoAdminDto(Admin admin){
        return new AdminDto(admin.getId(),admin.getAdminName(), admin.getAdminPassword());
    }
}
