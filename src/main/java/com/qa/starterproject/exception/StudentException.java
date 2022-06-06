package com.qa.starterproject.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student does not exist")
public class StudentException extends EntityNotFoundException {

	private static final long serialVersionUID = -5888268436139419786L;

}
