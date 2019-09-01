package com.webapp.mvc.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	//controller to show welcome screen
			@RequestMapping("/")
			public String welcome(){
				return "welcome";
			}
}
