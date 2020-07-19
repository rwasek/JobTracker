package com.richardwasek.jobtracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="date_applied")
	private LocalDate dateApplied;
	
	@Column(name="job_title")
	private String jobTitle;
	
	private String location;
	
	private String contact;
	
	@Column(name="cover_letter")
	private boolean coverLetter;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	// Constructors:
	
	public Job() {
		super();
	}

	public Job(int id, String companyName, LocalDate dateApplied, String jobTitle, String location, String contact,
			boolean coverLetter, Status status) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.dateApplied = dateApplied;
		this.jobTitle = jobTitle;
		this.location = location;
		this.contact = contact;
		this.coverLetter = coverLetter;
		this.status = status;
	}
	
	// Methods:
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(boolean coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		Job other = (Job) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", companyName=" + companyName + ", dateApplied=" + dateApplied + ", jobTitle="
				+ jobTitle + ", location=" + location + ", contact=" + contact + ", coverLetter=" + coverLetter
				+ ", status=" + status + "]";
	}
	
	
	
	

}
