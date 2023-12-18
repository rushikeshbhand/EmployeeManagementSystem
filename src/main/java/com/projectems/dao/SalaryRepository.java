package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    
}
