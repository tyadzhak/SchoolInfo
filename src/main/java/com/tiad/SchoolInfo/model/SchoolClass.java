package com.tiad.SchoolInfo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class SchoolClass {
	@Id
	private ObjectId id;
	
	private ObjectId schoolId;
	
	private String name;
	
	//private List<Subject> subjects;

	public ObjectId getId() {
		return id;
	}
	
	public ObjectId getSchoolId() {
		return schoolId;
	}
	
	public void setSchoolId(ObjectId schoolId) {
		this.schoolId =  schoolId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
*/

	@Override
	public String toString() {
		return "SchoolClass [id=" + id + ", schoolId=" + schoolId + ", name=" + name + "]";
	}


}
