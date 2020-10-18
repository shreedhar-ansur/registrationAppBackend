package com.scrumConnect.demo.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.scrumConnect.demo.controller.v1.UserController;
import com.scrumConnect.demo.model.User;

@Component
public class SimpleUserModelAssembler implements SimpleRepresentationModelAssembler<User> {

	@Override
	public void addLinks(EntityModel<User> resource) {
		resource.add(linkTo(methodOn(UserController.class).getUser()).slash(resource.getContent().getName()).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<User>> resources) {
		resources.add(linkTo(methodOn(UserController.class).getUser()).withSelfRel());
	}
	
	@Override
	public CollectionModel<EntityModel<User>> toCollectionModel(Iterable<? extends User> entities) {
		return SimpleRepresentationModelAssembler.super.toCollectionModel(entities);
	}
}
