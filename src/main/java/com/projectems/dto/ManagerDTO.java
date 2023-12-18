package com.projectems.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ManagerDTO {
	
	private Long id;
   
	@NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    private Date joinDate;
}