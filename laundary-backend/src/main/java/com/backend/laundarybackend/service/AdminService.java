package com.backend.laundarybackend.service;

import com.backend.laundarybackend.dto.AdminDto;

public interface AdminService {
    AdminDto saveAdmin(AdminDto adminDto);
    boolean deleteAdminById(String id);


}
