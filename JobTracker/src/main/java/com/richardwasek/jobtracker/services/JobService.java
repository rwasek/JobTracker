package com.richardwasek.jobtracker.services;

import java.util.List;

import com.richardwasek.jobtracker.entities.Job;

public interface JobService {
	List<Job> getAll();
	Job findJobById(Integer jId);
	Job createNewJob(Job job);
	Job updateJob(Job job, Integer jId);
	void deleteJob(Integer jId);
	List<Job> findByCompanyName(String cName);
}
