package com.parika.payment.manager.services;
import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.util.ParametersHandle;

import java.util.List;

public interface PaymentService {

    Payment createPayment(ParametersHandle parametersHandle);

    List<Payment> getAllPayments();

    Payment getSinglePayment(int id);

    Payment updatePayment(ParametersHandle parametersHandle, int id);

    void deletePayment(int id);

}
