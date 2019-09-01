package com.crm.springhibernate.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.springhibernate.demo.entity.Customer;
import com.crm.springhibernate.demo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
		
	@GetMapping("/listAll")
	public String listCustomers(Model model){
		
			
		//Get customer from DAOs
		List<Customer> customers = this.customerService.getAllCustomers();
		
		//add those customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		//create model attribute to bind form data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		//save the customer
		this.customerService.saveUpdateCustomer(customer);
		
		return "redirect:/customer/listAll";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model){
		
		//get the customer from database
		Optional<Customer> customer = this.customerService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id,Model model){
		
		//delete the customer
		this.customerService.deleteCustomer(id);
		
		return "redirect:/customer/listAll";
		
	}
}
