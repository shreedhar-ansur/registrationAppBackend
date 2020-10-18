package com.scrumConnect.demo.controller.v1.country;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scrumConnect.demo.model.Country;
import com.scrumConnect.demo.repository.CountryRepository;

@RestController
@RequestMapping("/v1/country")
@PropertySource(value = "app.properties")
public class InitializeContries {

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${country.url}")
	String countryUrl;

	@RequestMapping(value = "/init", method = RequestMethod.GET )
	@PostConstruct
	public HttpEntity<Integer> initializeCountries() {
		ResponseEntity<Country[]> result = restTemplate.exchange(countryUrl, HttpMethod.GET, null, Country[].class);
		countryRepository.clearCountries();
		return new HttpEntity<Integer>(countryRepository.addMultipleCountries(Arrays.asList(result.getBody())));
	}

}
