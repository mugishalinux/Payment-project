package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepo extends JpaRepository<PaymentType,Integer> {
}
