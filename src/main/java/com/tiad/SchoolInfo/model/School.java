package com.tiad.SchoolInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "school", schema = "school_diary")
public class School{
	public School() {
	
	}
	
	public School(String name/*, Set<SchoolClassEntity> classes, Set<TeacherEntity> teacher, Set<ChildEntity> children*/) {
		this.name = name;
		/*this.classes = classes;
		this.teachers = teacher;
		this.children = children;*/
	}
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "school_sequence", schema = "school_diary")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "post_index")
	private String postIndex;
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=SchoolClassEntityImpl.class)
	private Set<SchoolClassEntity> classes;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=TeacherEntityImpl.class)
	private Set<TeacherEntity> teachers;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=ChildEntityImpl.class)
	private Set<ChildEntity> children;*/
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}

	/*@Override
	public Set<SchoolClassEntity> getClasses() {
		return classes;
	}
	
	@Override
	public <T extends SchoolClass> void setClasses(Set<T> classes){
		this.classes = (Set<SchoolClassEntity>) classes;
	}

	@Override
	public Set<TeacherEntity> getTeachers() {
		return teachers;
	}
	
	@Override
	public <T extends Teacher> void setTeachers(Set<T> teachers){
		this.teachers = (Set<TeacherEntity>) teachers;
	}

	@Override
	public Set<ChildEntity> getChildren() {
		return children;
	}
	
	@Override
	public <T extends Child> void setChildren(Set<T> children){
		this.children = (Set<ChildEntity>) children;
	}*/
	
	//@Override
	/*
	public void setId(long id) {
		this.id = id;
	}*/

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", postIndex="
				+ postIndex + "]";
	}
}
