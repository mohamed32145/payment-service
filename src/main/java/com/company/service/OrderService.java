package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.beans.Order;
import com.company.repository.OrderDAO;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderdao;

	public void createOrder(Order order) {
		
		
		orderdao.saveOrder(order);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
