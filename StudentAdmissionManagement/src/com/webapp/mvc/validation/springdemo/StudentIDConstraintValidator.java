package com.webapp.mvc.validation.springdemo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentIDConstraintValidator implements ConstraintValidator<StudentID, String> {

	private String studIDPrefix;
	
	//To get handle on actual annotation passed in variable coursePrefix
	@Override
	public void initialize(StudentID constraintAnnotation) {
		studIDPrefix=constraintAnnotation.value();
		
	}

	//Validation logic---code should start with string present in coursePrefix
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;
		
		if(code != null)
			result = code.startsWith(studIDPrefix);
		else
			result = true;
		
		return result;
	}

}
