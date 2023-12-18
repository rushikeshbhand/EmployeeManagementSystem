package com.projectems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.converter.SalaryConverter;
import com.projectems.dao.SalaryRepository;
import com.projectems.dto.SalaryDTO;
import com.projectems.entities.Salary;
import com.projectems.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private SalaryConverter salaryConverter;

    @Override
    public SalaryDTO getSalaryById(Long id) {
        Salary salary = salaryRepository.findById(id).orElse(null);
        return salaryConverter.entityToDto(salary);
    }

    @Override
    public SalaryDTO createSalary(SalaryDTO salaryDTO) {
        Salary salary = salaryConverter.dtoToEntity(salaryDTO);
        salary = salaryRepository.save(salary);
        return salaryConverter.entityToDto(salary);
    }

    @Override
    public SalaryDTO updateSalary(SalaryDTO salaryDTO) {
        Salary salary = salaryConverter.dtoToEntity(salaryDTO);
        salary.setId(salaryDTO.getId());
        salary = salaryRepository.save(salary);
        return salaryConverter.entityToDto(salary);
    }

    @Override
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
