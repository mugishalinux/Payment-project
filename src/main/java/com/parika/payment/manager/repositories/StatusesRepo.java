package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusesRepo extends JpaRepository<Status, Integer> {
}
