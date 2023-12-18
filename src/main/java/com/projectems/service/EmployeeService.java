package com.projectems.service;

import java.util.List;
import com.projectems.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    List<EmployeeDTO> getAllEmployees();
}
