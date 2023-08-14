package com.webapp.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {
	
	
	@RequestMapping("/name")
	public String name() {
		
		return "shaz";
	}
	
	

}
