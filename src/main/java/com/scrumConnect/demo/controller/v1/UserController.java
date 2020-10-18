package com.scrumConnect.demo.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrumConnect.demo.assembler.SimpleUserModelAssembler;
import com.scrumConnect.demo.model.User;
import com.scrumConnect.demo.repository.UserRepository;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SimpleUserModelAssembler simpleUserModelAssembler;

	@RequestMapping(path="/{userId}", method = RequestMethod.GET)
	public HttpEntity<User> getUser(@PathVariable(value = "userId") String userId) {
		User person = userRepository.getUserById(userId);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public ResponseEntity<CollectionModel<EntityModel<User>>> getUser() {
		return ResponseEntity.ok(simpleUserModelAssembler.toCollectionModel(userRepository.getUsers()));
	}
}
