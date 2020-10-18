package com.scrumConnect.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.scrumConnect.demo.model.RegistrationForm;

@Component
public class FormValidator implements ConstraintValidator<FormValidation, RegistrationForm>{
	
	@Override
	public boolean isValid(RegistrationForm form, ConstraintValidatorContext context) {
		return true;
	}

}
