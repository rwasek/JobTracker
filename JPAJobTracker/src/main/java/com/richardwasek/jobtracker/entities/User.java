package com.richardwasek.jobtracker.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Job> jobs;

	public User() {
		super();
	}

	public User(int id, String firstName, String username, String password, boolean enabled, List<Job> jobs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.jobs = jobs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public void addJob(Job job) {
		if (jobs == null) {
			jobs = new ArrayList<>();
		}
		
		if (!jobs.contains(job)) {
			jobs.add(job);
			if(job.getUser() != null) {
				job.getUser().getJobs().remove(job);
			}
			job.setUser(this);
		}
	}
	
	public void removeJob(Job job) {
		job.setUser(null);
		if(jobs != null) {
			jobs.remove(job);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}
	
	

}
