package com.crm.springhibernate.demo.service;

import java.util.List;
import java.util.Optional;

import com.crm.springhibernate.demo.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	void saveUpdateCustomer(Customer customer);

	Optional<Customer> getCustomer(int id);

	void deleteCustomer(int id);
}
