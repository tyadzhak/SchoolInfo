package com.tiad.SchoolInfo.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolInfo.model.School;
import com.tiad.SchoolInfo.repository.SchoolRepository;

@Service(value="schoolService")
@Transactional
public class SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	public School create(School school) {
		return schoolRepository.save(school);
	}
	
	public School findById(ObjectId id) {
		return schoolRepository.findOne(id);
	}

	public School delete(ObjectId id){
		School deletedSchool = schoolRepository.findOne(id);	
		schoolRepository.delete(deletedSchool);
		return deletedSchool;
	}

	public School[] findAll() {
		return schoolRepository.findAll().toArray(new School[0]);
	}

	public School update(School school){
		School updatedSchool = schoolRepository.findOne(school.getId());
				
		updatedSchool.setName(school.getName());
		return updatedSchool;
	}

	public boolean exists(ObjectId id) {
		return schoolRepository.exists(id);
	}
}
