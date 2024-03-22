package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.beans.Order;
import com.company.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderservice;
	

	@PostMapping(value="/order/add" ,consumes ="application/json")
	public void createDepartment(@RequestBody Order order )
	{
		
		orderservice.createOrder(order);
		
		
		
		
	}
	
	
	
	

}
