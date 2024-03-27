package com.company.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.beans.Order;
import com.company.beans.Payment;
import com.company.service.OrderService;
import com.company.service.PaymentService;

import exceptions.PaymentNotFound;

@RestController
public class PaymentController {

	@Autowired
	PaymentService PaymentService;

	@Autowired
	OrderService orderservice;

	@PostMapping(value = "/payment/add", consumes = "application/json")
	public void createPayment(@RequestBody Payment pay) {

		PaymentService.createPayment(pay);

	}

	@PostMapping(value = "/payment/pay", consumes = "application/json")
	public void makeApayment(@RequestBody Order order) {

		PaymentService.pay(order);

	}

	@DeleteMapping("/payment/{paymentid}")
	public ResponseEntity<?> deletepayment(@PathVariable int paymentid) {
		try {

			PaymentService.cancelPay(paymentid);
			return new ResponseEntity<>("PAyment deleted successfully", HttpStatus.NO_CONTENT);

		} catch (PaymentNotFound e) {

			return new ResponseEntity<>("payment not found", HttpStatus.NOT_FOUND);
		}
  
	}

	@GetMapping("/payment/{paymentid}")
	public ResponseEntity<?> getPaymentbyid(@PathVariable int paymentid) {
		try {

			Payment payment = PaymentService.getPaymentbyid(paymentid);
			return new ResponseEntity<>(payment, HttpStatus.OK);

		} catch (PaymentNotFound e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

}
