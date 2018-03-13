package com.esbdev.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.esbdev.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResouceExceptionHendler {

	@ExceptionHandler(ObjectNotFoundException.class)
	ResponseEntity<StandardError> objetctNotFound(ObjectNotFoundException e, HttpServletRequest request ) {

		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
