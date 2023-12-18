package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
