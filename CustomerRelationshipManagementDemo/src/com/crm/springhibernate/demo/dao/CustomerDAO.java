package com.crm.springhibernate.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.crm.springhibernate.demo.entity.Customer;

@Repository
public class CustomerDAO implements DAO<Customer>{

	@Autowired
	private SessionFactory seesionFactory;	
	

	@Override	
	public List<Customer> findAll() {
		
		//get current hibernate session
		Session session = this.seesionFactory.getCurrentSession();
		
		//create a query to get list of customers and sort by last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		
		//return the result
		return customers;
	}

	@Override	
	public void saveorUpdate(Customer customer) {
		
		//get current hibernate session
		Session session = this.seesionFactory.getCurrentSession();
		
		//save or update the customer object in database
		session.saveOrUpdate(customer);
	}

	@Override	
	public void deleteById(int id) {
		
		//get current hibernate session
		Session session = this.seesionFactory.getCurrentSession();
		
		//delete object with primary key
		Query query = session.createQuery("delete from Customer where id=:custId");
		query.setParameter("custId", id);
		
		query.executeUpdate();
	}

	@Override
	public Customer findById(int id) {
		
		//get current hibernate session
		Session session = this.seesionFactory.getCurrentSession();
			
		//now retreive customer from database using primary key
		Customer customer = session.get(Customer.class,id);
		
		return customer;
	}

}
