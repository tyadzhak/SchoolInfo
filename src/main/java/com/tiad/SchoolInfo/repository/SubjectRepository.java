package com.tiad.SchoolInfo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, ObjectId>{
	List<Subject> findAllByOrderByName();
	Subject[] findByName(String name);
}