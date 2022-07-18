package com.parika.payment.manager.services;
import com.parika.payment.manager.models.PayableType;

import java.util.List;

public interface PayableTypeService {

    PayableType createPayableType(PayableType payableType);

    List<PayableType> getAllPayableType();

    PayableType getSinglePayableType(int id);

    PayableType updatePayableType(PayableType payableType, int id);

    void deletePayableType(int id);
}
