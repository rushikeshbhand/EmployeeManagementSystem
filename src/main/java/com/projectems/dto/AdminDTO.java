package com.projectems.dto;

import lombok.Data;

@Data //Lombok's @Data annotation will automatically generate getters,and other necessary methods for you 

public class AdminDTO 
{
	private Long id;
  //  @NotBlank
    private String username;

 //   @NotBlank
    private String password;

//    @Email
    private String email;

    // private Date joinDate;

	
		
	}
