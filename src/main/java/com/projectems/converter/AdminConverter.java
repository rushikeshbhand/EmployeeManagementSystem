package com.projectems.converter;

import org.springframework.stereotype.Component;

import com.projectems.dto.AdminDTO;
import com.projectems.entities.Admin;

@Component
public class AdminConverter {
	
      public AdminDTO entityToDto(Admin admin) {
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setId(admin.getId());
            adminDTO.setUsername(admin.getUsername());
            adminDTO.setPassword(admin.getPassword());
            adminDTO.setEmail(admin.getEmail());
            return adminDTO;
        }
    public Admin dtoToEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        return admin;
    }


        
}
