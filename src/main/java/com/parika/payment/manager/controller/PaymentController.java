package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.services.PaymentService;
import com.parika.payment.manager.util.ParametersHandle;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }

    @ApiOperation(value="Create a payment")
    @PostMapping("")
    public ResponseEntity<Payment> createPayment(@RequestBody ParametersHandle parametersHandle){
        return new ResponseEntity<Payment>(paymentService.createPayment(parametersHandle), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of all Payments")
    @GetMapping()
    List<Payment> getAllPayment(){
        return paymentService.getAllPayments();
    }

    @ApiOperation(value="Retrieve single Payment by using ID")
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") int id){
        return paymentService.getSinglePayment(id);
    }
    @ApiOperation(value="Update a Payment by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody ParametersHandle parametersHandle, @PathVariable("id") int id){
        return new ResponseEntity<Payment>(paymentService.updatePayment(parametersHandle,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Payment by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") int id){
        paymentService.deletePayment(id);
        return new ResponseEntity<String>("Payment deletion successfully!!!",HttpStatus.OK);
    }
}
