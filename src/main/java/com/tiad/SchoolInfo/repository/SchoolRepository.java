package com.tiad.SchoolInfo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.School;
import com.tiad.SchoolInfo.model.SchoolClass;

@Repository
public interface SchoolRepository extends MongoRepository<School, ObjectId> {
	List<School> findAllByOrderByName();

	School[] findByName(String name);

	School[] findByPostalCode(String postalCode);

	//@Query("select o.schoolClass from School o where o.id = ?1")
	//List<SchoolClass> findSchoolClassById(ObjectId id);
	
	//List<SchoolClass> findSchoolClassesBySchoolsId(@Param("customer") Customer customer);
}
