package com.projectems.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LeaveDTO {

    private Long id;

    @NotNull
    private Long employeeId; // Use the employee's ID to link to an employee

    @NotBlank
    private String reason;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;
}
