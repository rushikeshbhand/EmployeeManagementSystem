package com.projectems.service.impl;  //Service class which implements EmployeeServiceInterface

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.EmployeeConverter;
import com.projectems.dao.EmployeeRepository;
import com.projectems.dto.EmployeeDTO;
import com.projectems.entities.Employee;
import com.projectems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employeeConverter.entityToDto(employee);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.dtoToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return employeeConverter.entityToDto(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.dtoToEntity(employeeDTO);
        employee.setId(employeeDTO.getId());
        employee = employeeRepository.save(employee);
        return employeeConverter.entityToDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
            .map(employeeConverter::entityToDto)
            .collect(Collectors.toList());
    }
}
