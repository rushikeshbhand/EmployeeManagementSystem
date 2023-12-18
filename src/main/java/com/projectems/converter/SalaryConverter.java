package com.projectems.converter;

import org.springframework.stereotype.Component;

import com.projectems.dto.SalaryDTO;
import com.projectems.entities.Salary;

@Component
public class SalaryConverter {

    public SalaryDTO entityToDto(Salary salary) {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(salary.getId());
        salaryDTO.setAmount(salary.getAmount());
        salaryDTO.setPaymentDate(salary.getPaymentDate());
        return salaryDTO;
    }

    public Salary dtoToEntity(SalaryDTO salaryDTO) {
        Salary salary = new Salary();
        salary.setId(salaryDTO.getId());
        salary.setAmount(salaryDTO.getAmount());
        salary.setPaymentDate(salaryDTO.getPaymentDate());
        return salary;
    }
}
