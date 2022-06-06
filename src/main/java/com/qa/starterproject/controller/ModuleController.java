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

import com.qa.starterproject.domain.Module;
import com.qa.starterproject.dto.ModuleDto;
import com.qa.starterproject.service.ModuleService;

@RestController
@RequestMapping("/module")
@CrossOrigin
public class ModuleController {
	
	private ModuleService service;

	public ModuleController(ModuleService service) {
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<ModuleDto> create(@RequestBody Module module) {
		return new ResponseEntity<ModuleDto>(this.service.create(module), HttpStatus.CREATED);
	}

	// read
	@GetMapping("/readAll")
	public ResponseEntity<List<ModuleDto>> read() {
		return new ResponseEntity<List<ModuleDto>>(this.service.readAll(), HttpStatus.OK);
	}

	// read ID
	@GetMapping("/read/{id}")
	public ResponseEntity<ModuleDto> readId(@PathVariable Long id) throws Exception {
		return new ResponseEntity<ModuleDto>(this.service.readId(id), HttpStatus.OK);
	}

	// find module by title
	@GetMapping("/title/{str}")
	public ResponseEntity<List<ModuleDto>> findByTitle(@PathVariable String str) {
		return new ResponseEntity<List<ModuleDto>>(this.service.findByTitle(str), HttpStatus.OK);
	}
	

	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<ModuleDto> update(@PathVariable Long id, @RequestBody Module module) throws Exception {
		return new ResponseEntity<ModuleDto>(this.service.update(id, module), HttpStatus.ACCEPTED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
