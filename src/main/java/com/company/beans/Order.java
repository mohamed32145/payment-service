package com.company.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "\"order\"")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI - server response on the index value of th id column 
	@Column(name="order_id")
	private int order_id ;
	
	@Column(name="price")
	private double price;
	
	@Column(name="currency")
    private String currency;
	
	@Column(name="method")
    private String method;
    
	@Column(name="intent")
    private String intent;
	
	@Column(name="description")
    private String description;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name= "pay_id" , nullable = true)
	private Payment payment;
    
    
	public Order(int id, double price, String currency, String method, String intent, String description) {
		this.order_id = id;
		this.price = price;
		this.currency = currency;
		this.method = method;
		this.intent = intent;
		this.description = description;
	}
	
	public Order() {
        // Default constructor
    }


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public int getId() {
		return order_id;
	}


	public void setId(int id) {
		this.order_id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getIntent() {
		return intent;
	}


	public void setIntent(String intent) {
		this.intent = intent;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
    
    
    

	
	
	
	
	
	
	

}
