package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.PayableType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayableTypeRepo extends JpaRepository<PayableType , Integer> {
}
