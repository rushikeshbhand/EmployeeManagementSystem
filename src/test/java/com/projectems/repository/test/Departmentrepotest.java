package com.projectems.repository.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.DepartmentRepository;
import com.projectems.dto.DepartmentDTO;
import com.projectems.entities.Department;
import com.projectems.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
public class Departmentrepotest
{
	@InjectMocks
    private DepartmentRepository departmentRepository;

    @Mock
    private DepartmentService departmentService;

    @Test
    public void testCreateDepartment() {
        // Create a sample DepartmentDTO
        
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(1L); // Replace with the desired ID
        departmentDTO.setName("Sample Department"); // Replace with the desired name
        // You can set other properties as needed for your test

        // Mock the behavior of the departmentRepository.save method
        when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> {
            Department department = invocation.getArgument(0);
            department.setId(1L); // Simulate the generated ID
            return department;
        });

        // Call the repository method to create a department
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);

        // Verify that the service method was called with the correct DepartmentDTO
        verify(departmentService, times(1)).createDepartment(departmentDTO);

        // Assert that the createdDepartment matches the expected DepartmentDTO
        assertEquals(departmentDTO.getId(), createdDepartment.getId());
        assertEquals(departmentDTO.getName(), createdDepartment.getName());
        // You can add additional assertions for other properties as needed
    }
}