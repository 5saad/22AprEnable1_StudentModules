package com.qa.starterproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
	
	private Long id;
	private String firstName;
	private String surname;
	private String course;
	private int yearOfStudy;

}
