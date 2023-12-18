package com.projectems.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "Managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "join_date")
    private Date joinDate;
    
    @OneToOne
    @JoinColumn(name = "user_id") 
    private User user;


 // Many-to-Many relationship with Admins
    @ManyToMany
    @JoinTable(name = "admin_manager",
        joinColumns = @JoinColumn(name = "manager_id"),
        inverseJoinColumns = @JoinColumn(name = "admin_id")
    )
    private List<Admin> admins;
    
 // One-to-Many relationship with Employees
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;

    
   // One-to-One relationship with Department, Manager can manage only one Department at a time
    @OneToOne(mappedBy = "manager")
    private Department department;
   
}
