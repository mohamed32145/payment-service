package com.company.repository;

import org.springframework.stereotype.Repository;

import com.company.beans.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrderDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	

	public  void saveOrder(Order order) 
	{
		
		entityManager.persist(order);
		
	}

}
