package com.richardwasek.jobtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardwasek.jobtracker.services.JobService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4212"})
public class JobController {
	@Autowired
	JobService jobSvc;

}
