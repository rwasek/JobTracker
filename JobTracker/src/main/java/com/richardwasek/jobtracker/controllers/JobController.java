package com.richardwasek.jobtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardwasek.jobtracker.entities.Job;
import com.richardwasek.jobtracker.services.JobService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4212"})
public class JobController {
	@Autowired
	JobService jobSvc;
	
	@GetMapping("jobs")
	public List<Job> index(){
		return jobSvc.getAll();
	}
	
	@GetMapping("jobs/{jId}")
	public Job retrieve(
			@PathVariable Integer jId,
			HttpServletResponse res
	){
		Job job = jobSvc.findJobById(jId);
		if (job == null) {
			res.setStatus(404); // if null 404 - no job with that id
		}
		return job;
	}
	
	@PostMapping("jobs")
	public Job create(
			@RequestBody Job job,
			HttpServletResponse res,
			HttpServletRequest req
	){
		try {
			job = jobSvc.createNewJob(job);
			res.setStatus(201); // 201, successfully created new job
			StringBuffer url = req.getRequestURL();
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			job = null;
		}
		return job;
	}
	
	@PutMapping("jobs/{jId}")
	public Job updateJob(
			@RequestBody Job job,
			@PathVariable Integer jId,
			HttpServletResponse res			
	){
		try {
			job = jobSvc.updateJob(job, jId);
			if (job == null) {
				res.setStatus(404);
			}
			return job;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400); // bad request due to poor data
			job = null;
		}
		return job;
	}
	
	@DeleteMapping("jobs/{jId}")
	public void deleteJob(
			@PathVariable Integer jId,
			HttpServletResponse res
	){
		try {
			if(jobSvc.deleteJobById(jId)) {
				res.setStatus(204); // id was valid, 204 no content - successful deletion
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(409); // conflict - trying to delete id with child relationships
		}
	}
	
	@GetMapping("jobs/search/companyName/{cName}")
	public List<Job> findJobsByCompanyName(
			@PathVariable String cName,
			HttpServletResponse res
	){
		List<Job> jobs = null;
		try {
			jobs = jobSvc.findByCompanyName(cName);
			if (cName == null) {
				res.setStatus(404);
			}
			return jobs;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			jobs = null;
		}
		return jobs;
	}
}
