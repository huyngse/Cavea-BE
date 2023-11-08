package com.example.demo.Repo;

import com.example.demo.Entities.sales.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    Optional<Payment> findPaymentByPaymentId(Integer paymentID);
}
