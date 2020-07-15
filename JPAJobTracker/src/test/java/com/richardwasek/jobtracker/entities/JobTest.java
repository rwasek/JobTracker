package com.richardwasek.jobtracker.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.richardwasek.jobtracker.entities.Job;

class JobTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Job job;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JobTrackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		job = em.find(Job.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		job = null;
		em.close();
	}
	@Test
	@DisplayName("testing Job entity mappings")
	void test() {
		assertNotNull(job);
		assertEquals("cFocus Software", job.getCompanyName());
		assertEquals(7, job.getDateApplied().getMonth().getValue());
		assertEquals("Junior Software Developer", job.getJobTitle());
		assertEquals("Research Triangle Park, NC", job.getLocation());
		assertEquals(Status.PENDING, job.getStatus());
		assertEquals(true, job.isCoverLetter());
		assertEquals("Rich", job.getUser().getFirstName());
	}

}
