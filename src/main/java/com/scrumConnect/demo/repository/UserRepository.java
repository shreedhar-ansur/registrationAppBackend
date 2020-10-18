package com.scrumConnect.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.scrumConnect.demo.model.User;


@Repository
public class UserRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public User insertUser(User user) {
		return mongoTemplate.insert(user);
	}
	
	public User getUserById(String userId) {
		return mongoTemplate.findById(userId, User.class);
	}
	
	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}
}
