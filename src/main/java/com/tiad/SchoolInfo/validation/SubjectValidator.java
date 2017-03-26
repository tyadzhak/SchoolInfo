package com.tiad.SchoolInfo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tiad.SchoolInfo.model.Subject;
import com.tiad.SchoolInfo.repository.SubjectRepository;

@Component
public class SubjectValidator implements Validator {
	private final static String SUBJECT_NAME = "name";
	
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Subject.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Subject subject = (Subject) target;

		ValidationUtils.rejectIfEmpty(errors, SUBJECT_NAME, "subject.name.empty");
		
	}
}
