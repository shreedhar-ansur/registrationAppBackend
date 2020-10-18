package com.scrumConnect.demo.controller.v1.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scrumConnect.demo.repository.CountryRepository;

@RestController
@RequestMapping("/v1/country")
public class ClearCountries {


	@Autowired
	CountryRepository countryRepository;
	
	@RequestMapping(value = "/clearAll", method = RequestMethod.GET )
	public HttpEntity<Long> clearCountries() {
		return new HttpEntity<Long>(countryRepository.clearCountries());
	}
}
