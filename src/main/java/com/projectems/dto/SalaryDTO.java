package com.projectems.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SalaryDTO {
	
	private Long id;
    @NotNull
    private BigDecimal amount;

    @NotNull
    private Date paymentDate;
}