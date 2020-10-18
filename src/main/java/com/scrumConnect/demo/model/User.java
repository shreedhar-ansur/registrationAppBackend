package com.scrumConnect.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.scrumConnect.demo.validation.GenderValidation;

import lombok.AllArgsConstructor;

@Document(collection = "User")
@AllArgsConstructor
@Component
public class User {

	@Id
	@NotEmpty
	String name;
	
	@NotNull
	@GenderValidation
	String gender;
	
	@Min(1)
	@Max(100)
	int age;

	@NotNull
	String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
