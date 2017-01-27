package com.tiad.SchoolInfo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tiad.SchoolInfo.model.School;
import com.tiad.SchoolInfo.repository.SchoolRepository;

@Component
public class SchoolValidator implements Validator {

	private final static String SCHOOL_NAME = "name";
	private final static String SCHOOL_POSTAL_CODE = "postalCode";

	@Autowired
	SchoolRepository schoolRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return School.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		School school = (School) target;

		ValidationUtils.rejectIfEmpty(errors, SCHOOL_NAME, "school.name.empty");
		ValidationUtils.rejectIfEmpty(errors, SCHOOL_POSTAL_CODE,
				"school.postalCode.empty");

		/*
		School[] schs = schoolRepository.findByName(school.getName());
		if (schs.length != 0) {
			errors.rejectValue(SCHOOL_NAME, "school.name.alreadyExist");
		}

		schs = schoolRepository.findByPostalCode(school.getPostalCode());
		if (schs.length != 0) {
			errors.rejectValue(SCHOOL_POSTAL_CODE,
					"school.postalCode.alreadyExist");
		}
		*/
	}
}
