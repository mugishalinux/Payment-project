package com.parika.payment.manager.services;

import com.parika.payment.manager.models.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    PaymentType createPaymentType(PaymentType paymentType);

    List<PaymentType> getAllPaymentType();

    PaymentType getSinglePaymentType(int id);

    PaymentType updatePaymentType(PaymentType paymentType, int id);

    void deletePaymentType(int id);

}
