package com.projectems.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class DepartmentDTO {
	
	private Long id;
	
    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
