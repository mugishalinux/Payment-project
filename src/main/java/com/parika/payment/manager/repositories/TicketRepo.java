package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Tickets, Integer> {
}
