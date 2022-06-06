package com.qa.starterproject.dto;

import java.util.List;

import com.qa.starterproject.domain.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModuleDto {

	private Long id;
	private String title;
	private String prefix;
	private String firstName;
	private String Surname;
	private List<Student> students;

}
