package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
