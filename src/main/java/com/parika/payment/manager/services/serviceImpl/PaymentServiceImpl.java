package com.parika.payment.manager.services.serviceImpl;
import com.parika.payment.manager.exceptions.ApiRequestException;
import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.models.PaymentType;
import com.parika.payment.manager.models.Ticket;
import com.parika.payment.manager.repositories.PayableTypeRepo;
import com.parika.payment.manager.repositories.PaymentRepo;
import com.parika.payment.manager.repositories.PaymentTypeRepo;
import com.parika.payment.manager.services.PaymentService;
import com.parika.payment.manager.util.ParametersHandle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepo paymentRepo;
    private PaymentTypeRepo paymentTypeRepo;
    private PayableTypeRepo payableTypeRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo, PaymentTypeRepo paymentTypeRepo, PayableTypeRepo payableTypeRepo) {
        super();
        this.paymentRepo = paymentRepo;
        this.paymentTypeRepo = paymentTypeRepo;
        this.payableTypeRepo = payableTypeRepo;
    }

    @Override
    public Payment createPayment(ParametersHandle parametersHandle) {
        if(parametersHandle.getPaymentTypeId() == 0){
            throw new ApiRequestException("please provide the payment type id");
        } else if (parametersHandle.getAmountPaid() == 0) {
            throw new ApiRequestException("please provide gthe amount paid");
        } else if (parametersHandle.getInitiatedBy() == null) {
            throw new ApiRequestException("please provide the initiator name");
        } else if (parametersHandle.getPaidBy() == null) {
            throw new ApiRequestException("please provide the payer name");
        } else if (parametersHandle.getPayableTypeId() == 0) {
            throw new ApiRequestException("please provide the payable type id");
        } else if (parametersHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (parametersHandle.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        } else{

            //create a temporary ticket id
            Ticket ticket = new Ticket(101010);


            //check if payment type exist into a database
            PaymentType paymentType = paymentTypeRepo.findById(parametersHandle.getPaymentTypeId()).orElseThrow(()->new ApiRequestException("This Payment Type Id don't exist in our database"));
            //check if payableType id exist into database
            PayableType payableTypeExist = payableTypeRepo.findById(parametersHandle.getPayableTypeId()).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));

            Payment payment = new Payment();
            payment.setPaymentType(paymentType);
            payment.setTicketId(ticket);
            payment.setAmountPaid(parametersHandle.getAmountPaid());
            payment.setInitiatedBy(parametersHandle.getInitiatedBy());
            payment.setPaidBy(parametersHandle.getPaidBy());
            payment.setPayableType(payableTypeExist);
            payment.setPayableReference("10101010");
            payment.setExternalPaymentReference("20e0-p2z2-o0l2-m0x2");
            payment.setCreationTime(LocalTime.now());
            payment.setStatusId(parametersHandle.getStatusId());
            payment.setCreatedBy(parametersHandle.getCreatedBy());
            payment.setUpdatedBy(parametersHandle.getCreatedBy());
            payment.setCreatedAt(LocalDateTime.now());
            payment.setUpdatedAt(LocalDateTime.now());
            return paymentRepo.save(payment);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getSinglePayment(int id) {
        return paymentRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Id don't exist in our database"));
    }

    @Override
    public Payment updatePayment(ParametersHandle parametersHandle, int id) {

        // check if payment id exist
        Payment payment = paymentRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Id don't exist in our database"));

        if(parametersHandle.getPaymentTypeId() == 0){
            throw new ApiRequestException("please provide the payment type id");
        } else if (parametersHandle.getAmountPaid() == 0) {
            throw new ApiRequestException("please provide the amount paid");
        } else if (parametersHandle.getInitiatedBy() == null) {
            throw new ApiRequestException("please provide the initiator name");
        } else if (parametersHandle.getPaidBy() == null) {
            throw new ApiRequestException("please provide the payer name");
        } else if (parametersHandle.getPayableTypeId() == 0) {
            throw new ApiRequestException("please provide the payable type id");
        } else if (parametersHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else{

            //create a temporary ticket id
            Ticket ticket = new Ticket(101010);


            //check if payment type exist into a database
            PaymentType paymentType = paymentTypeRepo.findById(parametersHandle.getPaymentTypeId()).orElseThrow(()->new ApiRequestException("This Payment Type Id don't exist in our database"));
            //check if payableType id exist into database
            PayableType payableTypeExist = payableTypeRepo.findById(parametersHandle.getPayableTypeId()).orElseThrow(()->new ApiRequestException("This Payable Type Id don't exist in our database"));

            payment.setPaymentType(paymentType);
            payment.setTicketId(ticket);
            payment.setAmountPaid(parametersHandle.getAmountPaid());
            payment.setInitiatedBy(parametersHandle.getInitiatedBy());
            payment.setPaidBy(parametersHandle.getPaidBy());
            payment.setPayableType(payableTypeExist);
            payment.setPayableReference("10101010");
            payment.setExternalPaymentReference("20e0-p2z2-o0l2-m0x2");
            payment.setCreationTime(payment.getCreationTime());
            payment.setStatusId(parametersHandle.getStatusId());
            payment.setCreatedBy(payment.getCreatedBy());
            payment.setUpdatedBy(parametersHandle.getUpdatedBy());
            payment.setCreatedAt(payment.getCreatedAt());
            payment.setUpdatedAt(LocalDateTime.now());
            return paymentRepo.save(payment);
        }
    }

    @Override
    public void deletePayment(int id) {
        paymentRepo.findById(id).orElseThrow(()->new ApiRequestException("This Payment Id don't exist in our database"));
        paymentRepo.deleteById(id);
    }
}
