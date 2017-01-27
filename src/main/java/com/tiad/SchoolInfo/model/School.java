package com.tiad.SchoolInfo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class School {
	public School() {

	}

	public School(String name) {
		this.name = name;
	}

	@Id
	private ObjectId id;

	private String name;

	private String postalCode;

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
		return "School [id=" + id + ", name=" + name + ", postalCode="
				+ postalCode + "]";
	}
}
