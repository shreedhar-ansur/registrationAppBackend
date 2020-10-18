package com.scrumConnect.demo.exception;

import java.util.ArrayList;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.scrumConnect.demo.model.FormErrorMessage;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		FormErrorMessage formErrorMessage = new FormErrorMessage();
		for(FieldError oe: ex.getBindingResult().getFieldErrors()) {
			if(null==formErrorMessage.getError().get(oe.getField())) {
				formErrorMessage.getError().put(oe.getField(), new ArrayList<String>());
			}
			formErrorMessage.getError().get(oe.getField()).add(oe.getDefaultMessage());
		}
		formErrorMessage.setErrorDetail("Invalid request");
		return new ResponseEntity<>(formErrorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<String> handle(ConstraintViolationException exception, WebRequest request) {
		return new ResponseEntity<String>("some error", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> exception(Exception exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
