package com.projectems.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor()
@AllArgsConstructor(staticName="build")
@Data
public class UserDTO {
   

	private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String role;

   
}

