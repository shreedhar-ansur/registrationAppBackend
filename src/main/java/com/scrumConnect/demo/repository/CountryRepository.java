package com.scrumConnect.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.scrumConnect.demo.model.Country;

@Repository
public class CountryRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Country getCountry(String Id) {
		return mongoTemplate.findById(Id, Country.class);
	}
	
	public List<Country> getAllCountries() {
		return mongoTemplate.findAll(Country.class);
	}
	
	public Long clearCountries() {
		return mongoTemplate.remove(new Query(), Country.class).getDeletedCount();
	}
	
	public Integer addMultipleCountries(List<Country> countries) {
		return mongoTemplate.insert(countries, Country.class).size();
	}
}
