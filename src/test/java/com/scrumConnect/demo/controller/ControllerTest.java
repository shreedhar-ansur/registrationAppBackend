package com.scrumConnect.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	
	@InjectMocks
	Controller controller;
	
	@Test
	public void homeTest() {
		assertEquals(new ResponseEntity<String>("Welcome to registration user API.", HttpStatus.OK), controller.home());
	}

}
