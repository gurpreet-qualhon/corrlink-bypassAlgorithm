package com.example.bypassAlgorithm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses {

	@Id
	private long id;

	public Courses(long id, String name, String description) {
//		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Courses() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String name;
	private String description;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
