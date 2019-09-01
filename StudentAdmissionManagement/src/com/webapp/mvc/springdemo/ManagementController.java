package com.webapp.mvc.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class ManagementController {

	//controller to show details
		@RequestMapping("/showForm")
		public String displayDetails(){
			return "mngt-page";
		}
}
