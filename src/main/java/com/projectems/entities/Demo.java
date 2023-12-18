package com.projectems.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Registration")
@Inheritance(strategy = InheritanceType.JOINED)
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int demoId;
	private String demoUsername;
	private String demoPassword;
	
}
