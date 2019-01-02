package br.com.unidev.base.resource.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.unidev.base.exceptions.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	ResponseEntity<ErroPadrao> notFound(NotFoundException e, HttpServletRequest request) {
		ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
	}

}
