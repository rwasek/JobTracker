package com.richardwasek.jobtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richardwasek.jobtracker.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
	List<Job> findByCompanyNameContaining(String cName);

}
