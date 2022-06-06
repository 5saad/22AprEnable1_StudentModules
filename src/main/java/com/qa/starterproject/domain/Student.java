package com.qa.starterproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String surname;
	private String course;
	private int yearOfStudy;
	
//	@ManyToOne(targetEntity = Driver.class)
//	private Driver driver;

}
