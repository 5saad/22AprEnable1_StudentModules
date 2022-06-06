package com.qa.starterproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Student;
import com.qa.starterproject.dto.StudentDto;
import com.qa.starterproject.exception.StudentException;
import com.qa.starterproject.repo.StudentRepo;

@Service
public class StudentService {

	private ModelMapper mapper;

	private StudentRepo repo;

	public StudentService(StudentRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private StudentDto mapToDto(Student car) {
		return this.mapper.map(car, StudentDto.class);
	}

	// create student
	public StudentDto create(Student student) {
		return this.mapToDto(this.repo.save(student));
	}

	// read student
	public List<StudentDto> readAll() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	// read student by id
	public StudentDto readId(Long id) throws StudentException {
		return this.mapToDto(this.repo.findById(id).orElseThrow(StudentException::new));
	}

	// update student
	public StudentDto update(Long id, Student student) throws StudentException {
		Student exists = this.repo.findById(id).orElseThrow(StudentException::new);
		exists.setFirstName(student.getFirstName());
		exists.setSurname(student.getSurname());
		exists.setCourse(student.getCourse());
		exists.setYearOfStudy(student.getYearOfStudy());
		return this.mapToDto(this.repo.saveAndFlush(exists));
	}

	// delete student
	public boolean delete(Long id) throws StudentException {
		this.repo.findById(id).orElseThrow(StudentException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// find student by surname
	public List<StudentDto> findBySurname(String str) {
		return this.repo.findBySurname(str).stream().map(this::mapToDto).collect(Collectors.toList());
	}

}
