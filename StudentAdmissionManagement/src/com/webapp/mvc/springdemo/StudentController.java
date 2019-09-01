package com.webapp.mvc.springdemo;

import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.mvc.models.springdemo.Student;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{nativeOptions}") 
	private LinkedHashMap<String, String> nativeOptions;
	
	/*Preprocess every String form data, remove leading or trailing whitespaces.
	 *If string has only whitespaces trim it to become null. 
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		//StringTrimmerEditor defined in SpringAPI to trim whitespaces from strings
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	//controller to show initial form
	@RequestMapping("/showForm")
	public String showForm(Model model){
		model.addAttribute("studentData", new Student());
		model.addAttribute("nativeOptions", nativeOptions); 
		return "main-menu";
	}

	//controller to show process the form
		@RequestMapping("/processForm")
		public String processForm(@Valid @ModelAttribute("studentData")Student student,
				BindingResult bindingResults,Model model){
			
			if(bindingResults.hasErrors()){
				model.addAttribute("nativeOptions", nativeOptions); 
				return "main-menu";
			}
				
			else{
			String firstName= student.getFirstName();
			String lastName= student.getLastName();
			
			firstName= firstName.substring(0,1).toUpperCase().concat(firstName.substring(1).toLowerCase());
			lastName= lastName.substring(0,1).toUpperCase().concat(lastName.substring(1).toLowerCase());
			
			student.setFullName(firstName.concat(" ").concat(lastName));
			
			if(student.getcountryOfResidence().equalsIgnoreCase("None"))
				student.setCountryOfResidence("No entry");
			else
				student.setCountryOfResidence(student.getCountryOptions().get(student.getcountryOfResidence()));
				
			student.setNativeCountry(this.nativeOptions.get(student.getNativeCountry()));
			
			return "home-page";
		}
		}
}
