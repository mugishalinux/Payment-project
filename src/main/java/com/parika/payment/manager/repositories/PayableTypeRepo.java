package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.PayableType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayableTypeRepo extends JpaRepository<PayableType , Integer> {
}
