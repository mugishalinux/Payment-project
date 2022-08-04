package com.parika.payment.manager.repositories;

import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.models.PaymentType;
import com.parika.payment.manager.models.Tickets;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{
    List<Payment> findByPaymentType(PaymentType paymentType, Pageable pageable);
    List<Payment> findByPayableType(PayableType payableType, Pageable pageable);
    List<Payment> findByTicketsId(Tickets tickets, Pageable pageable);
    List<Payment> findByPaymentTypeAndPayableTypeAndTicketsId(PaymentType paymentType,PayableType payableType,Tickets tickets,Pageable pageable);
}
