package com.projectems.converter;

import org.springframework.stereotype.Component;

import com.projectems.dto.ManagerDTO;
import com.projectems.entities.Manager;

@Component
public class ManagerConverter {
    public ManagerDTO entityToDto(Manager manager) {
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId()); 
        managerDTO.setUsername(manager.getUsername());
        managerDTO.setPassword(manager.getPassword());
        managerDTO.setEmail(manager.getEmail());
        managerDTO.setJoinDate(manager.getJoinDate()); 
        return managerDTO;
    }

    public Manager dtoToEntity(ManagerDTO managerDTO) {
        Manager manager = new Manager();
        manager.setId(managerDTO.getId()); 
        manager.setUsername(managerDTO.getUsername());
        manager.setEmail(managerDTO.getEmail());
        manager.setPassword(managerDTO.getPassword());
        manager.setJoinDate(managerDTO.getJoinDate());
        return manager;
        }
        
//        public List<ManagerDTO> entityListToDtoList(List<Manager> managers) {
//            return managers.stream()
//                    .map(this::entityToDto)
//                    .collect(Collectors.toList());
//    }
}
