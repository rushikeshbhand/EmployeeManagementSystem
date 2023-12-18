package com.projectems.service;

import com.projectems.dto.SalaryDTO;

public interface SalaryService {
    SalaryDTO getSalaryById(Long id);
    SalaryDTO createSalary(SalaryDTO salaryDTO);
    SalaryDTO updateSalary(SalaryDTO salaryDTO);
    void deleteSalary(Long id);
}
