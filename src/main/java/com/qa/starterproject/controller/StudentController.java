package com.qa.starterproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.domain.Student;
import com.qa.starterproject.dto.StudentDto;
import com.qa.starterproject.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<StudentDto> create(@RequestBody Student student) {
		return new ResponseEntity<StudentDto>(this.service.create(student), HttpStatus.CREATED);
	}

	// read
	@GetMapping("/readAll")
	public ResponseEntity<List<StudentDto>> read() {
		return new ResponseEntity<List<StudentDto>>(this.service.readAll(), HttpStatus.OK);
	}

	// read ID
	@GetMapping("/read/{id}")
	public ResponseEntity<StudentDto> readId(@PathVariable Long id) throws Exception {
		return new ResponseEntity<StudentDto>(this.service.readId(id), HttpStatus.OK);
	}

	// find student by surname
	@GetMapping("/surname/{str}")
	public ResponseEntity<List<StudentDto>> findBySurname(@PathVariable String str) {
		return new ResponseEntity<List<StudentDto>>(this.service.findBySurname(str), HttpStatus.OK);
	}
	

	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody Student student) throws Exception {
		return new ResponseEntity<StudentDto>(this.service.update(id, student), HttpStatus.ACCEPTED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
