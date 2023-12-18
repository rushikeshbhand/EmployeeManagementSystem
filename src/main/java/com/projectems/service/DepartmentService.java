package com.projectems.service;

import java.util.List;

import com.projectems.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO getDepartment(Long id);
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id);
    String deleteDepartment(Long id);
    String deleteAllDepartments();
	DepartmentDTO getDepartmentById(Long id);
	List<DepartmentDTO> getAllDepartments();
}
