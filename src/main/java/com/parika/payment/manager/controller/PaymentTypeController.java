package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.PaymentType;
import com.parika.payment.manager.services.PaymentTypeService;
import com.parika.payment.manager.util.DeleteApiResponse;
import com.parika.payment.manager.util.PostApiResponse;
import com.parika.payment.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment/paymentType")
public class PaymentTypeController {
    private PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        super();
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createPaymentType(@RequestBody PaymentType paymentType){
        PostApiResponse response = new PostApiResponse();
        try{
            paymentTypeService.createPaymentType(paymentType);
            response.setMessage("Successfully");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @GetMapping()
    Page<PaymentType> getAllPaymentType(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int sizePage,
                                        @RequestParam(defaultValue = "id") String sortBy){
        return paymentTypeService.getAllPaymentType(page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable("id") int id){
        return paymentTypeService.getSinglePaymentType(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updatePaymentType(@RequestBody PaymentType paymentType, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            paymentTypeService.updatePaymentType(paymentType,id);
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
    public ResponseEntity<DeleteApiResponse> deleteParkingArea(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            paymentTypeService.deletePaymentType(id);
            response.setMessage("Record Deleted");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
