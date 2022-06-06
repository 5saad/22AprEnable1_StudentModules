package com.qa.starterproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Module;
import com.qa.starterproject.dto.ModuleDto;
import com.qa.starterproject.exception.ModuleException;
import com.qa.starterproject.repo.ModuleRepo;

@Service
public class ModuleService {

	private ModelMapper mapper;

	private ModuleRepo repo;

	public ModuleService(ModuleRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private ModuleDto mapToDto(Module car) {
		return this.mapper.map(car, ModuleDto.class);
	}

	// create module
	public ModuleDto create(Module module) {
		return this.mapToDto(this.repo.save(module));
	}

	// read module
	public List<ModuleDto> readAll() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	// read module by id
	public ModuleDto readId(Long id) throws ModuleException {
		return this.mapToDto(this.repo.findById(id).orElseThrow(ModuleException::new));
	}

	// update module
	public ModuleDto update(Long id, Module module) throws ModuleException {
		Module exists = this.repo.findById(id).orElseThrow(ModuleException::new);
		exists.setTitle(module.getTitle());
		exists.setPrefix(module.getPrefix());
		exists.setFirstName(module.getFirstName());
		exists.setSurname(module.getSurname());
		return this.mapToDto(this.repo.saveAndFlush(exists));
	}

	// delete module
	public boolean delete(Long id) throws ModuleException {
		this.repo.findById(id).orElseThrow(ModuleException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// find module by title
	public List<ModuleDto> findByTitle(String str) {
		return this.repo.findByTitle(str).stream().map(this::mapToDto).collect(Collectors.toList());
	}

}
