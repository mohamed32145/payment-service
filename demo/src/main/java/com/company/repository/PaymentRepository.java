package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.beans.Payment;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	//Payment findPaymentByPay_id(int id);
	
	
	
	

	
	

}
