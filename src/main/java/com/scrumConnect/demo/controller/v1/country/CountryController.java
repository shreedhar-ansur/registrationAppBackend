package com.scrumConnect.demo.controller.v1.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrumConnect.demo.assembler.SimpleCountryModelAssmbler;
import com.scrumConnect.demo.model.Country;
import com.scrumConnect.demo.repository.CountryRepository;

@RestController
@RequestMapping("/v1/country")
public class CountryController {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	SimpleCountryModelAssmbler simpleCountryModelAssmbler;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public ResponseEntity<CollectionModel<EntityModel<Country>>> getCountryList() {
		return ResponseEntity.ok(simpleCountryModelAssmbler.toCollectionModel(countryRepository.getAllCountries()));
	}
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
	public ResponseEntity<EntityModel<Country>> getCountry(@PathVariable(value = "Id") String Id) {
		return ResponseEntity.ok(simpleCountryModelAssmbler.toModel(countryRepository.getCountry(Id)));
	}

}
