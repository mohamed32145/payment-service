package com.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.repository.OrderDAO;
import com.company.repository.PaymentDAO;
import com.company.repository.PaymentRepository;
import com.tsfn.service.exceptions.CouponNotFoundException;

import exceptions.PaymentNotFound;

import com.company.beans.*;

@Service
public class PaymentService {

	@Autowired
	PaymentDAO paymentdao;

	@Autowired
	OrderDAO orderdao;

	@Autowired
	PaymentRepository paymentrepo;

	public String pay(Order order) {

		Payment pay = new Payment();
		pay.setTotalAmount(order.getPrice());
		pay.setOrders(List.of(order));
		paymentdao.savePay(pay);
		return "was saved";

	}

	// public String initiateDeposit () {}

	public void createPayment(Payment pay) {

		paymentdao.savePay(pay);
	};



	//public void cancelPay(int id) throws PaymentNotFound {

	//	Payment pay = paymentrepo.findById(id)
	//			.orElseThrow(() -> new PaymentNotFound("payment with id" + id + " not found"));
	//	paymentrepo.delete(pay);

	//}
	
	public void cancelPay(int id) throws PaymentNotFound {
	    Optional<Payment> optionalPayment = paymentrepo.findById(id);
	    
	    if (optionalPayment.isPresent()) {
	        Payment pay = optionalPayment.get();
	        paymentrepo.delete(pay);
	    } else {
	        throw new PaymentNotFound("Payment with ID " + id + " not found");
	    }
	}
	
	
	
	
	
	

	public Payment getPaymentbyid(int id) {

		// return paymentrepo.findPaymentByPay_id(id);
		Optional<Payment> optionalPayment = paymentrepo.findById(id);
		if (optionalPayment.isPresent()) {
			return optionalPayment.get();
		} else {
			// Handle the case where the payment with the given ID is not found
			throw new PaymentNotFound("Payment not found for ID: " + id);
		}

	}

}
