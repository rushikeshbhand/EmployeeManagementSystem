package com.projectems.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectems.dto.DepartmentDTO;
import com.projectems.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

     
    @GetMapping("/departments/{id}")
        public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
    	DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentDTO);  
    }
   
    @PostMapping("/createDepartments")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }
   
    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long id) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentDTO, id);
//        if (updatedDepartment != null) {
//            return ResponseEntity.ok(updatedDepartment);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(updatedDepartment);
    }
   
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartmentByID(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
//        if (result.equals("deleted")) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.noContent().build();

        
    }

   
    
    
}
