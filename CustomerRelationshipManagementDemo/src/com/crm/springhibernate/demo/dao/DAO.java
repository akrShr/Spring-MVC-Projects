package com.crm.springhibernate.demo.dao;

import java.util.List;


public interface DAO<T> {

		public List<T> findAll();
		
		T findById(int id);
		
		void saveorUpdate(T t);
		
		void deleteById(int id);
		
		}

