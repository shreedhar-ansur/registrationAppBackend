package com.scrumConnect.demo.assembler;

import org.springframework.stereotype.Component;

import com.scrumConnect.demo.controller.v1.country.CountryController;
import com.scrumConnect.demo.model.Country;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

@Component
public class SimpleCountryModelAssmbler implements SimpleRepresentationModelAssembler<Country> {

	@Override
	public void addLinks(EntityModel<Country> resource) {
		resource.add(linkTo(methodOn(CountryController.class).getCountryList()).slash(resource.getContent().getNumericCode()).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Country>> resources) {
		resources.add(linkTo(methodOn(CountryController.class).getCountryList()).withSelfRel());
	}
	
	@Override
	public CollectionModel<EntityModel<Country>> toCollectionModel(Iterable<? extends Country> entities) {
		return SimpleRepresentationModelAssembler.super.toCollectionModel(entities);
	}


}
