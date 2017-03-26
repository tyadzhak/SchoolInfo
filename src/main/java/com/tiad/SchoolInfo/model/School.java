package com.tiad.SchoolInfo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class School {
	/*
	public School() {

	}

	public School(String name) {
		this.name = name;
	}*/

	@Id
	private ObjectId id;

	private String name;

	private String postalCode;
	
	//private List<SchoolClass> schoolClass;

	public ObjectId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", postalCode=" + postalCode + "]";
	}

	/*
	public List<SchoolClass> getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(List<SchoolClass> schoolClass) {
		this.schoolClass = schoolClass;
	}
*/


}
