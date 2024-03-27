package com.company.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.beans.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PaymentRepository paymentrepo;

	public void savePay(Payment pay) {

		entityManager.persist(pay);

	}

	public void delete(int id) {

		// Payment pay= paymentrepo.findPaymentByPay_id(id);

		//Payment pay = paymentrepo.findById(id);

	//	entityManager.remove(pay);

	}

}
