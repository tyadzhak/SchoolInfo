package com.tiad.SchoolInfo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, ObjectId>{
	List<School> findAllByOrderByName();
	School[] findByName(String name);
	School[] findByPostalCode(String postalCode);
}
