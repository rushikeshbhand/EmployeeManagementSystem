package com.projectems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.ManagerConverter;
import com.projectems.dao.ManagerRepository;
import com.projectems.dto.ManagerDTO;
import com.projectems.entities.Manager;
import com.projectems.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerConverter managerConverter;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerConverter managerConverter) {
        this.managerRepository = managerRepository;
        this.managerConverter = managerConverter;
    }

	@Override
	public ManagerDTO getManagereById(Long id) {
		 Manager manager = managerRepository.findById(id).orElse(null);
              // .orElseThrow(() -> new ManagerNotFoundException("Manager not found with id: " + id));
       return managerConverter.entityToDto(manager);
      // Employee employee = employeeRepository.findById(id).orElse(null);
      // return employeeConverter.entityToDto(employee);
	}

	@Override
	public ManagerDTO createManager(ManagerDTO managerDTO) {
		Manager manager = managerConverter.dtoToEntity(managerDTO);
        manager = managerRepository.save(manager);
        return managerConverter.entityToDto(manager);
	}

	@Override
	public ManagerDTO updateManager(ManagerDTO managerDTO) {
		 Manager manager = managerConverter.dtoToEntity(managerDTO);
	        manager = managerRepository.save(manager);
	        return managerConverter.entityToDto(manager);
	}

	@Override
	public void deleteManager(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ManagerDTO> getAllManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagerDTO getManagerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}