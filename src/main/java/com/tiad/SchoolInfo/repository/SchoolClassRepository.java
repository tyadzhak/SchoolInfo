package com.tiad.SchoolInfo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.SchoolClass;
import com.tiad.SchoolInfo.model.Subject;

@Repository
public interface SchoolClassRepository extends MongoRepository<SchoolClass, ObjectId>{
	List<SchoolClass> findAllByOrderByName();
	SchoolClass[] findByName(String name);
	List<Subject> findAllSubjectById(ObjectId id);
	
	List<SchoolClass> findBySchoolId(ObjectId schoolId);
	
	//@Query("select u from User u where u.firstname = :#{#customer.firstname}")
	//List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
}