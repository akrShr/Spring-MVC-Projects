package com.crm.springhibernate.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.springhibernate.demo.dao.DAO;
import com.crm.springhibernate.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private DAO<Customer> dao;
	
	@Transactional
	@Override
	public List<Customer> getAllCustomers(){		
		return this.dao.findAll();
	}

	@Transactional
	@Override
	public void saveUpdateCustomer(Customer customer) {
		this.dao.saveorUpdate(customer);
		
	}

	@Transactional
	@Override
	public Optional<Customer>  getCustomer(int id) {
		Customer customer= this.dao.findById(id);		
		return  Optional.ofNullable(customer);
				
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		this.dao.deleteById(id);
		
	}

}
