package com.projectems.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "Salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "Total_Amount")
    private long amount;

    @NotNull
    @Column(name = "Payment_Date")
    private Date paymentDate;

    //The Salary entity is related to the Employee entity.
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
