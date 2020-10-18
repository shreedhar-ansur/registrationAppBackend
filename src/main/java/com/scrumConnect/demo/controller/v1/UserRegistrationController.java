package com.scrumConnect.demo.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrumConnect.demo.assembler.SimpleUserModelAssembler;
import com.scrumConnect.demo.model.RegistrationForm;
import com.scrumConnect.demo.model.User;
import com.scrumConnect.demo.repository.UserRepository;

@RestController
@RequestMapping("/v1/register")
public class UserRegistrationController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SimpleUserModelAssembler simpleUserModelAssembler;

	@Validated
	@PostMapping(path="/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EntityModel<User>> registerUser(@Valid @RequestBody RegistrationForm form) throws Exception {
		return ResponseEntity.ok(simpleUserModelAssembler.toModel(userRepository.insertUser(form.getUser())));
	}

}
