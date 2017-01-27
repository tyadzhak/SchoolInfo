package com.tiad.SchoolInfo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, ObjectId>{
	School[] findByName(String name);
	School[] findByPostalIndex(String postalIndex);
}
