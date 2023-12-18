package com.projectems.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "Leave_Requests")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "Leave_Reason", length = 200)
    private String reason;

    @NotNull
    @Column(name = "Start_date")
    private Date startDate;

    @NotNull
    @Column(name = "End_date")
    private Date endDate;

    // Many-to-One relationship with Employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

   
}
