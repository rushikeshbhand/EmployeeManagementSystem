package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
