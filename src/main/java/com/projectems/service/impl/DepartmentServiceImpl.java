package com.projectems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.DepartmentConverter;
import com.projectems.dao.DepartmentRepository;
import com.projectems.dto.DepartmentDTO;
import com.projectems.entities.Department;
import com.projectems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	 @Autowired
    private  DepartmentRepository departmentRepository;
	 @Autowired
    private  DepartmentConverter departmentConverter;

   
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public DepartmentDTO getDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
            .map(departmentConverter::entityToDto)
            .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentConverter.dtoToEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id) {
        Department department = departmentConverter.dtoToEntity(departmentDTO);
        department.setId(id);
        department = departmentRepository.save(department);
        return departmentConverter.entityToDto(department);
    }

    @Override
    public String deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return "deleted";
        }
        return "not found";
    }

    @Override
    public String deleteAllDepartments() {
        departmentRepository.deleteAll();
        return "deleted";
    }

	@Override
	public DepartmentDTO getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
