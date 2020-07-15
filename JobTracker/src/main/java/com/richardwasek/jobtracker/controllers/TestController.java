package com.richardwasek.jobtracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
//@CrossOrigin()
public class TestController {
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}
