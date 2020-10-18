package com.scrumConnect.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class GenderValidator implements ConstraintValidator<GenderValidation, String>{
	
	@Override
	public boolean isValid(String gender, ConstraintValidatorContext context) {
		return (null!=gender && ( gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")))? true : false;
	}
}
