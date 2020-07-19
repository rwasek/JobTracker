package com.richardwasek.jobtracker.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardwasek.jobtracker.entities.Job;
import com.richardwasek.jobtracker.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	JobRepository jobRepo;
	
	@Override
	public List<Job> getAll() {
		return jobRepo.findAll();
	}

	@Override
	public Job findJobById(Integer jId) {
		Optional<Job> optJob = jobRepo.findById(jId);
		Job job = null;
		if (optJob.isPresent()) {
			job = optJob.get();
		}
		return job;
	}

	@Override
	public Job createNewJob(Job job) {
		return jobRepo.save(job);
	}

	@Override
	public Job updateJob(Job job, Integer jId) {
		Job managedJob = null;
		Optional<Job> existingJob = jobRepo.findById(jId);
		if(existingJob.isPresent()) {
			managedJob = existingJob.get();
			managedJob.setCompanyName(job.getCompanyName());
			managedJob.setContact(job.getContact());
			managedJob.setCoverLetter(job.isCoverLetter());
			managedJob.setDateApplied(job.getDateApplied());
			managedJob.setJobTitle(job.getJobTitle());
			managedJob.setLocation(job.getLocation());
			managedJob.setStatus(job.getStatus());
//			managedJob.setUser(job.getUser()); for when I do user auth
			jobRepo.saveAndFlush(managedJob);
		}
		return managedJob;
	}

	@Override
	public void deleteJob(Integer jId) {
		Optional<Job> jobToDelete = jobRepo.findById(jId);
		Job managedJob = null;
		if(jobToDelete.isPresent()) {
			managedJob = jobToDelete.get();
			jobRepo.delete(managedJob);
		}
	}

	@Override
	public List<Job> findByCompanyName(String cName) {
		return jobRepo.findByCompanyNameContaining(cName);
	}

}
