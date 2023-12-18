package com.projectems.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    
    //@NotBlank
    @Column(name = "Department_Name", length = 20)
    private String name;

    
    @Column(name = "description", length = 100)
    private String description;

    // One-to-One relationship with Manager
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
   
    //One-to-Many relationship with Employee
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    //Each Department can have multiple Employee records, 
    //allowing one manager to handle multiple employees within their department
}
