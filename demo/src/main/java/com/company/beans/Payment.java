package com.company.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"payment\"")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI - server response on the index value of th id column
	@Column(name = "pay_id")
	private int pay_id;

	@Column(name = "totalAmount")
	private double totalAmount;

	@JsonManagedReference
	@OneToMany(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Order> orders;

	
	
	
	public int getPay_id() {
		return pay_id;
	}
	




	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}




	public List<Order> getOrders() {
		return orders;
	}




	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
	    this.totalAmount = totalAmount;
	}
}



