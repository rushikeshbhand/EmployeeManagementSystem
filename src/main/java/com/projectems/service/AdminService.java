package com.projectems.service;

import java.util.List;
import com.projectems.dto.AdminDTO;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO adminDTO);
    AdminDTO getAdminById(Long id);
    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);
    String deleteAdmin(Long id);
    List<AdminDTO> getAllAdmins();
}
