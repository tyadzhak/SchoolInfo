package com.tiad.SchoolInfo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tiad.SchoolInfo.model.SchoolClass;
import com.tiad.SchoolInfo.repository.SchoolClassRepository;

@Component
public class SchoolClassValidator implements Validator {
	private final static String SCHOOL_CLASS_NAME = "name";
	
	@Autowired
	SchoolClassRepository schoolClassRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SchoolClass.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SchoolClass schoolClass = (SchoolClass) target;

		ValidationUtils.rejectIfEmpty(errors, SCHOOL_CLASS_NAME, "schoolClass.name.empty");
		
	}
}
