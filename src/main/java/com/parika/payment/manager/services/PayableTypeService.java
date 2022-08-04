package com.parika.payment.manager.services;
import com.parika.payment.manager.models.PayableType;
import org.springframework.data.domain.Page;
import java.util.List;

public interface PayableTypeService {

    PayableType createPayableType(PayableType payableType);

    Page<PayableType> getAllPayableType(int page, int sizePage, String sortBy);

    PayableType getSinglePayableType(int id);

    PayableType updatePayableType(PayableType payableType, int id);

    void deletePayableType(int id);
}
