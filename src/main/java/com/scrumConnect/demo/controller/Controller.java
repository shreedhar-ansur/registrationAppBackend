package com.scrumConnect.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/")
@SwaggerDefinition
public class Controller {
	
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<String> home() {
		return new ResponseEntity<String>("Welcome to registration user API.", HttpStatus.OK);
	}

}
