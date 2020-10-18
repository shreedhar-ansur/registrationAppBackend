package com.scrumConnect.demo.model;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scrumConnect.demo.validation.FormValidation;


@Entity
@Component
@FormValidation
public class RegistrationForm {

	@Autowired
	@NotNull
	@Valid
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
