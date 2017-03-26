package com.tiad.SchoolInfo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolInfo.model.SchoolClass;
import com.tiad.SchoolInfo.model.Subject;
import com.tiad.SchoolInfo.repository.SchoolClassRepository;

@Service(value="schoolClassService")
@Transactional
public class SchoolClassService {
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	public SchoolClass create(SchoolClass schoolClass) {
		return schoolClassRepository.save(schoolClass);
	}
	
	public SchoolClass findById(ObjectId id) {
		return schoolClassRepository.findOne(id);
	}
	
	public List<Subject> findAllSubjectById(ObjectId id) {
		return schoolClassRepository.findAllSubjectById(id);
	}
	/*
	public boolean addSubject(ObjectId schoolId, Subject subject){
		SchoolClass schoolClass = findById(schoolId);
		return schoolClass.getSubjects().add(subject);
	}*/

	public SchoolClass delete(ObjectId id){
		SchoolClass deletedSchoolClass = schoolClassRepository.findOne(id);	
		schoolClassRepository.delete(deletedSchoolClass);
		return deletedSchoolClass;
	}

	public SchoolClass[] findAllByOrderByName() {
		return schoolClassRepository.findAllByOrderByName().toArray(new SchoolClass[0]);
	}

	public SchoolClass update(ObjectId id, SchoolClass schoolClass){
		SchoolClass updatedSchoolClass = schoolClassRepository.findOne(id);
				
		updatedSchoolClass.setName(schoolClass.getName());
		return schoolClassRepository.save(updatedSchoolClass);
	}

	public boolean exists(ObjectId id) {
		return schoolClassRepository.exists(id);
	}
}
