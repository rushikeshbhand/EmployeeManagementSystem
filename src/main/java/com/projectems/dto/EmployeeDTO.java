package com.projectems.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id; // Use Long for ID to match the Employee entity

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;
   
    private String mon_no;
    
    private int age ;


    
}
