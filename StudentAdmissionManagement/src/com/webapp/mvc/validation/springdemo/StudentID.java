package com.webapp.mvc.validation.springdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = StudentIDConstraintValidator.class)//Class containing business rules to validate our custom annotation
@Target({ElementType.METHOD,ElementType.FIELD})//We can apply annotation on a method or a field
@Retention(RetentionPolicy.RUNTIME)//The annotation will be compiled and kept in bytecode to be used during runtime 
public @interface StudentID{ //@inteface defines custom annotation in java
	
	//default student ID if nothing is given
	public String value() default "NSD";

	//Validation Message displayed to the user
	public String message() default "must start with NSD";
	
	//grouping validation constraints together-- default group
	public Class<?>[] groups() default {};

	//give additional information about the validation error--default payloads
	public Class<? extends Payload>[] payload() default {};
}

