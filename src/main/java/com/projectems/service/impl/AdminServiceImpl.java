package com.projectems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.AdminConverter;
import com.projectems.dao.AdminRepository;
import com.projectems.dto.AdminDTO;
import com.projectems.entities.Admin;
import com.projectems.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private final AdminRepository adminRepository;
	
	@Autowired
    private final AdminConverter adminConverter;

    public AdminServiceImpl(AdminRepository adminRepository, AdminConverter adminConverter) {
        this.adminRepository = adminRepository;
        this.adminConverter = adminConverter;
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = adminConverter.dtoToEntity(adminDTO);
        admin = adminRepository.save(admin);
        return adminConverter.entityToDto(admin);
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
        return adminConverter.entityToDto(admin);
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) 
    {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
        Admin updatedAdmin = adminConverter.dtoToEntity(adminDTO);
        updatedAdmin.setId(existingAdmin.getId()); // Maintain the original ID
        adminRepository.save(updatedAdmin);
        return adminConverter.entityToDto(updatedAdmin);
    }

    @Override
    public String deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return "Admin with ID " + id + " has been deleted successfully.";
    }

	@Override
	public List<AdminDTO> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}
}