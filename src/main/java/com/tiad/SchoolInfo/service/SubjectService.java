package com.tiad.SchoolInfo.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolInfo.model.Subject;
import com.tiad.SchoolInfo.repository.SubjectRepository;

@Service(value="subjectService")
@Transactional
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject create(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public Subject findById(ObjectId id) {
		return subjectRepository.findOne(id);
	}

	public Subject delete(ObjectId id){
		Subject deletedSubject = subjectRepository.findOne(id);	
		subjectRepository.delete(deletedSubject);
		return deletedSubject;
	}

	public Subject[] findAllByOrderByName() {
		return subjectRepository.findAllByOrderByName().toArray(new Subject[0]);
	}

	public Subject update(ObjectId id, Subject subject){
		Subject updatedSubject = subjectRepository.findOne(id);
				
		updatedSubject.setName(subject.getName());
		return subjectRepository.save(updatedSubject);
	}

	public boolean exists(ObjectId id) {
		return subjectRepository.exists(id);
	}
}
