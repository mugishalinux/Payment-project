package com.parika.payment.manager.services.serviceImpl;

import com.parika.payment.manager.exceptions.ApiRequestException;
import com.parika.payment.manager.models.PaymentType;
import com.parika.payment.manager.repositories.PaymentTypeRepo;
import com.parika.payment.manager.services.PaymentTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    private PaymentTypeRepo paymentTypeRepo;

    public PaymentTypeServiceImpl(PaymentTypeRepo paymentTypeRepo) {
        super();
        this.paymentTypeRepo = paymentTypeRepo;
    }

    @Override
    public PaymentType createPaymentType(PaymentType paymentType) {
        if(paymentType.getPaymentTypeDesc() == null){
            throw new ApiRequestException("please provide the payment type name");
        } else if (paymentType.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (paymentType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            paymentType.setCreatedAt(LocalDateTime.now());
            paymentType.setCreatedBy(paymentType.getCreatedBy());
            paymentType.setUpdatedBy(paymentType.getCreatedBy());
            paymentType.setUpdatedAt(LocalDateTime.now());
            return paymentTypeRepo.save(paymentType);
        }
    }

    @Override
    public List<PaymentType> getAllPaymentType() {
        return paymentTypeRepo.findAll();
    }

    @Override
    public PaymentType getSinglePaymentType(int id) {
        return paymentTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Type Id don't exist in our database"));
    }

    @Override
    public PaymentType updatePaymentType(PaymentType paymentType, int id) {

        //check if payment type exits into database
        PaymentType paymentType1 = paymentTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Type Id don't exist in our database"));

        if(paymentType.getPaymentTypeDesc() == null){
            throw new ApiRequestException("please provide the payment type name");
        } else if (paymentType.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (paymentType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            paymentType1.setPaymentTypeDesc(paymentType.getPaymentTypeDesc());
            paymentType1.setCreatedAt(paymentType1.getCreatedAt());
            paymentType1.setCreatedBy(paymentType1.getCreatedBy());
            paymentType1.setUpdatedBy(paymentType.getUpdatedBy());
            paymentType1.setUpdatedAt(LocalDateTime.now());
            return paymentTypeRepo.save(paymentType1);
        }
    }

    @Override
    public void deletePaymentType(int id) {
        paymentTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Type Id don't exist in our database"));
        paymentTypeRepo.deleteById(id);
    }
}
