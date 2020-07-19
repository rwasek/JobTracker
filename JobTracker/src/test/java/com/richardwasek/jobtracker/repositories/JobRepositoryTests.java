package com.richardwasek.jobtracker.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.richardwasek.jobtracker.entities.Job;

@SpringBootTest
public class JobRepositoryTests {

	@Autowired
	JobRepository jobRepo;
	
	@Test
	@DisplayName("Testing basic repo workings")
	void test1() {
		List<Job> jobs = jobRepo.findAll();
		assertNotNull(jobs);
		assertEquals(true, jobs.size() > 0);
	}
	
	@Test
	@DisplayName("Test of find by company name containing")
	void test2() {
		List<Job> jobs = jobRepo.findByCompanyNameContaining("focus");
		assertNotNull(jobs);
		assertEquals(true, jobs.size() > 0);
	}
}
