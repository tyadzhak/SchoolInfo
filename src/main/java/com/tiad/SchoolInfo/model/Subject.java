package com.tiad.SchoolInfo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Subject {

	@Id
	private ObjectId id;

	private ObjectId schoolClassId;

	private String name;

	public ObjectId getId() {
		return id;
	}

	public ObjectId getSchoolClassId() {
		return schoolClassId;
	}

	public void setSchoolClassId(ObjectId schoolClassId) {
		this.schoolClassId = schoolClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", schoolClassId=" + schoolClassId + "]";
	}
}
