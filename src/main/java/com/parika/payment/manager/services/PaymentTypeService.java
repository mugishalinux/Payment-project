package com.parika.payment.manager.services;

import com.parika.payment.manager.models.PaymentType;
import org.springframework.data.domain.Page;
import java.util.List;

public interface PaymentTypeService {

    PaymentType createPaymentType(PaymentType paymentType);

    Page<PaymentType> getAllPaymentType(int page, int sizePage, String sortBy);

    PaymentType getSinglePaymentType(int id);

    PaymentType updatePaymentType(PaymentType paymentType, int id);

    void deletePaymentType(int id);

}
