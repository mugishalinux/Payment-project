package com.parika.payment.manager.services;
import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.util.ParametersHandle;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Payment createPayment(ParametersHandle parametersHandle);

    Page<Payment> getAllPayments(int page, int sizePage, String sortBy);

    Payment getSinglePayment(int id);

    Payment updatePayment(ParametersHandle parametersHandle, int id);

    void deletePayment(int id);

}
