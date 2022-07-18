package com.parika.payment.manager.services.serviceImpl;

import com.parika.payment.manager.exceptions.ApiRequestException;
import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.repositories.PayableTypeRepo;
import com.parika.payment.manager.services.PayableTypeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PayableTypeServiceImpl implements PayableTypeService {

    private PayableTypeRepo payableTypeRepo;

    public PayableTypeServiceImpl(PayableTypeRepo payableTypeRepo) {
        super();
        this.payableTypeRepo = payableTypeRepo;
    }

    @Override
    public PayableType createPayableType(PayableType payableType) {
        if(payableType.getPayableTypeDesc() == null){
            throw new ApiRequestException("please provide the payable type name");
        } else if (payableType.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (payableType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            payableType.setCreatedAt(LocalDateTime.now());
            payableType.setCreatedBy(payableType.getCreatedBy());
            payableType.setUpdatedBy(payableType.getCreatedBy());
            payableType.setUpdatedBy(payableType.getCreatedBy());
            return payableTypeRepo.save(payableType);
        }
    }

    @Override
    public List<PayableType> getAllPayableType() {
        return payableTypeRepo.findAll();
    }

    @Override
    public PayableType getSinglePayableType(int id) {
        return payableTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));
    }

    @Override
    public PayableType updatePayableType(PayableType payableType, int id) {

        //check if payableType id exist into database
        PayableType payableTypeExist = payableTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));

        if(payableType.getPayableTypeDesc() == null){
            throw new ApiRequestException("please provide the payable type name");
        } else if (payableType.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (payableType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            payableTypeExist.setPayableTypeDesc(payableType.getPayableTypeDesc());
            payableTypeExist.setCreatedAt(payableTypeExist.getCreatedAt());
            payableTypeExist.setCreatedBy(payableTypeExist.getCreatedBy());
            payableTypeExist.setUpdatedBy(payableType.getUpdatedBy());
            payableTypeExist.setUpdatedAt(LocalDateTime.now());
            return payableTypeRepo.save(payableType);
        }
    }

    @Override
    public void deletePayableType(int id) {
        payableTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));
        payableTypeRepo.deleteById(id);
    }
}
