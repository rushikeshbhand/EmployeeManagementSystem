package com.projectems.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private Long id;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;
   
    @OneToOne
    @JoinColumn(name = "user_id")  // 
    private User user;


 // Many-to-Many relationship with Managers
    @ManyToMany(mappedBy = "admins")
    private List<Manager> managers;
    //An Admin can manage multiple Managers, giving them access to data, related to multiple departments.

  
}
