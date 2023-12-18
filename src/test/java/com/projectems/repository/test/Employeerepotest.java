package com.projectems.repository.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.EmployeeRepository;
import com.projectems.entities.Employee;
import com.projectems.service.EmployeeService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Employeerepotest
{
	@InjectMocks
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() {
        // Create a sample Employee entity and ID
        Long employeeId = 1L;
        Employee employee = new Employee();

        // Mock the behavior of the employeeRepository.findById method
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // Call the repository method to get an employee by ID
        Optional<Employee> result = employeeRepository.findById(employeeId);

        // Verify that the service method was not called
        verify(employeeService, times(0)).getEmployeeById(employeeId);

        // Assert that the returned Optional contains the expected Employee entity
        assertTrue(result.isPresent());
        assertEquals(employeeId, result.get().getId());
        assertEquals("Riya Arora", result.get().getFirstName());
        assertEquals("Riya Arora", result.get().getLastName());
    }
}
