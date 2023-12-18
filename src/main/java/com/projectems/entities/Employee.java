package com.projectems.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;
    
    private String mon_no;
    
    private int age ;

    //Many-to-One relationship with Manager
    //Each Employee is linked to one Manager within the same department
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
    
 // The Employee entity can have a one-to-one relationship with the User entity
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    //Many-to-One relationship with Department
    //Each Employee is associated with one Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
