package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.Payment;
import com.parika.payment.manager.services.PaymentService;
import com.parika.payment.manager.util.DeleteApiResponse;
import com.parika.payment.manager.util.ParametersHandle;
import com.parika.payment.manager.util.PostApiResponse;
import com.parika.payment.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createPayment(@RequestBody ParametersHandle parametersHandle){
        PostApiResponse response = new PostApiResponse();
        try{
            paymentService.createPayment(parametersHandle);
            response.setMessage("Successfully");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
        return new ResponseEntity<Payment>(, HttpStatus.CREATED);
    }
    @GetMapping()
    Page<Payment> getAllPayment(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int sizePage,
                                @RequestParam(defaultValue = "id") String sortBy){
        return paymentService.getAllPayments(page,sizePage,sortBy);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") int id){
        return paymentService.getSinglePayment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updatePayment(@RequestBody ParametersHandle parametersHandle, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            paymentService.updatePayment(parametersHandle,id);
            response.setMessage("Successfully Updated");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteApiResponse> deletePayment(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            paymentService.deletePayment(id);
            response.setMessage("Successfully Updated");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
