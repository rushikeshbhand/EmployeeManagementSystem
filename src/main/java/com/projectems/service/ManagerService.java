package com.projectems.service;

import java.util.List;

import com.projectems.dto.ManagerDTO;

public interface ManagerService {
//	ManagerDTO getManagereById(Long id);
	ManagerDTO createManager(ManagerDTO managerDTO);
	ManagerDTO updateManager(ManagerDTO managerDTO);
	    void deleteManager(Long id);
	    List<ManagerDTO> getAllManager();
	//	ManagerDTO getManagerById(Long id);
		ManagerDTO getManagerById(Long id);
		ManagerDTO getManagereById(Long id);
}