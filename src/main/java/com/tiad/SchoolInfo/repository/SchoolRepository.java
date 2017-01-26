package com.tiad.SchoolInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolInfo.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
