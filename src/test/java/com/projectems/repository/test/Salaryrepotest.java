package com.projectems.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.SalaryRepository;
import com.projectems.entities.Salary;



@SpringBootTest
@DataJpaTest
public class Salaryrepotest {

    @Autowired
    private SalaryRepository salaryRepository;

    @Test
    public void testSaveAndGetSalary() {
        // Create a sample Salary
        Salary salary = new Salary();
        salary.setAmount(50000);

        // Save the Salary to the repository
        Salary savedSalary = salaryRepository.save(salary);

        // Retrieve the saved Salary
        java.util.Optional<Salary> retrievedSalary = salaryRepository.findById(savedSalary.getId());

        assertTrue(retrievedSalary.isPresent());
        assertEquals(savedSalary.getAmount(), retrievedSalary.get().getAmount());
    }

    @Test
    public void testDeleteSalary() {
        // Create a sample Salary
        Salary salary = new Salary();
        salary.setAmount(6000);

        // Save the Salary to the repository
        Salary savedSalary = salaryRepository.save(salary);

        // Delete the Salary
        salaryRepository.deleteById(savedSalary.getId());

        // Try to retrieve the deleted Salary
        java.util.Optional<Salary> deletedSalary = salaryRepository.findById(savedSalary.getId());

        assertFalse(deletedSalary.isPresent());
    }
}
