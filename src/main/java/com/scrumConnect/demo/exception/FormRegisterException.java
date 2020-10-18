package com.scrumConnect.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;

import com.scrumConnect.demo.model.FormErrorMessage;

public class FormRegisterException extends Exception {

	private static final long serialVersionUID = 1L;
	@Autowired
	FormErrorMessage formErrorMessage;
	
	public FormRegisterException(String message) {
		super(message);
	}
	
	public FormErrorMessage getFormErrorMessage() {
		return this.formErrorMessage;
	}
}
