package com.parika.payment.manager.services.serviceImpl;
import org.springframework.data.domain.Page;
import com.parika.payment.manager.exceptions.ApiRequestException;
import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.models.Status;
import com.parika.payment.manager.repositories.PayableTypeRepo;
import com.parika.payment.manager.repositories.StatusesRepo;
import com.parika.payment.manager.services.PayableTypeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PayableTypeServiceImpl implements PayableTypeService {

    private PayableTypeRepo payableTypeRepo;
    private StatusesRepo statusesRepo;

    public PayableTypeServiceImpl(PayableTypeRepo payableTypeRepo, StatusesRepo statusesRepo) {
        this.payableTypeRepo = payableTypeRepo;
        this.statusesRepo = statusesRepo;
    }

    @Override
    public PayableType createPayableType(PayableType payableType) {
        if(payableType.getPayableTypeDesc() == null){
            throw new ApiRequestException("please provide the payable type name");
        } else if (payableType.getStatus() == null) {
            throw new ApiRequestException("please provide the status id");
        } else if (payableType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            //check if status id exist
            Status status = statusesRepo.findById(payableType.getStatus().getId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));
            payableType.setStatus(status);
            payableType.setCreatedOnDt(LocalDateTime.now());
            payableType.setUpdatedOnDt(LocalDateTime.now());
            payableType.setCreatedBy(payableType.getCreatedBy());
            payableType.setUpdatedBy(payableType.getCreatedBy());
            payableType.setUpdatedBy(payableType.getCreatedBy());
            return payableTypeRepo.save(payableType);
        }
    }

    @Override
    public Page<PayableType> getAllPayableType(int page, int sizePage, String sortBy) {
        return payableTypeRepo.findAll(PageRequest.of(page,sizePage , Sort.Direction.ASC ,sortBy));
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
        } else if (payableType.getStatus() == null) {
            throw new ApiRequestException("please provide the status id");
        } else if (payableType.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator");
        }else {
            //check if status id exist
            Status status = statusesRepo.findById(payableType.getStatus().getId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));
            payableTypeExist.setPayableTypeDesc(payableType.getPayableTypeDesc());
            payableTypeExist.setCreatedOnDt(payableTypeExist.getCreatedOnDt());
            payableTypeExist.setCreatedBy(payableTypeExist.getCreatedBy());
            payableTypeExist.setUpdatedBy(payableType.getUpdatedBy());
            payableTypeExist.setUpdatedOnDt(LocalDateTime.now());
            payableTypeExist.setStatus(status);
            return payableTypeRepo.save(payableTypeExist);
        }
    }

    @Override
    public void deletePayableType(int id) {
        payableTypeRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));
        payableTypeRepo.deleteById(id);
    }
}
