package com.webapp.mvc.models.springdemo;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.webapp.mvc.validation.springdemo.StudentID;




public class Student {
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@StudentID
	private String studentID;
	
	@NotNull(message="is required")
	@Min(value=18,message="must be greater than or equal to 18")
	@Max(value=40,message="must be less than or equal to 40")
	private Integer age;
	
	@Pattern(regexp="^[0-9]{8,11}", message="length between 8 to 11 digits only")
	private String mobile;
			
	private String fullName;
	private String countryOfResidence;
	private String nativeCountry;	
	private String favProgLanguage;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> countryOptions;
		
	public Student(){
		this.countryOptions = new LinkedHashMap<>();
		this.populate();
	}
	
	private void populate(){
		this.countryOptions.put("None", "--Select--");
		this.countryOptions.put("DK", "Denmark");
		this.countryOptions.put("DE", "Germany");
		this.countryOptions.put("IN", "India");
		this.countryOptions.put("NO", "Norway");
		this.countryOptions.put("SE", "Sweden");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public String getcountryOfResidence() {
		return countryOfResidence;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getNativeCountry() {
		return nativeCountry;
	}
	
	public String getFavProgLanguage() {
		return favProgLanguage;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public Integer getAge() {
		return age;
	}

	public String getMobile() {
		return mobile;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}
	public void setFavProgLanguage(String favProgLanguage) {
		this.favProgLanguage = favProgLanguage;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
