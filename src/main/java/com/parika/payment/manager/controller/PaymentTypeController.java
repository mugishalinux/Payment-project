package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.models.PaymentType;
import com.parika.payment.manager.services.PaymentTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment/paymentType")
public class PaymentTypeController {
    private PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        super();
        this.paymentTypeService = paymentTypeService;
    }

    @ApiOperation(value="Create a Payment Type")
    @PostMapping("")
    public ResponseEntity<PaymentType> createPaymentType(@RequestBody PaymentType paymentType){
        return new ResponseEntity<PaymentType>(paymentTypeService.createPaymentType(paymentType), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Payment Type")
    @GetMapping()
    List<PaymentType> getAllPaymentType(){
        return paymentTypeService.getAllPaymentType();
    }

    @ApiOperation(value="Retrieve single Payment Type by using ID")
    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable("id") int id){
        return paymentTypeService.getSinglePaymentType(id);
    }
    @ApiOperation(value="Update a Payment Type by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<PaymentType> updatePaymentType(@RequestBody PaymentType paymentType, @PathVariable("id") int id){
        return new ResponseEntity<PaymentType>(paymentTypeService.updatePaymentType(paymentType,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Payment Type by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingArea(@PathVariable("id") int id){
        paymentTypeService.deletePaymentType(id);
        return new ResponseEntity<String>("Payment Type deletion successfully!!!",HttpStatus.OK);
    }
}
