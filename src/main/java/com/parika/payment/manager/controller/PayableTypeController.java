package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.services.PayableTypeService;
import com.parika.payment.manager.util.DeleteApiResponse;
import com.parika.payment.manager.util.PostApiResponse;
import com.parika.payment.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment/payableType")
public class PayableTypeController {
    private PayableTypeService payableTypeService;

    public PayableTypeController(PayableTypeService payableTypeService) {
        super();
        this.payableTypeService = payableTypeService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createPayableType(@RequestBody  PayableType payableType){
        PostApiResponse response = new PostApiResponse();
        try{
            payableTypeService.createPayableType(payableType);
            response.setMessage("Successfully ");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @GetMapping()
    Page<PayableType> getAllPayableType(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int sizePage,
                                        @RequestParam(defaultValue = "id") String sortBy){
        return payableTypeService.getAllPayableType(page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public PayableType getPayableTypeById(@PathVariable("id") int id){
        return payableTypeService.getSinglePayableType(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updatePayableType(@RequestBody PayableType payableType, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            payableTypeService.updatePayableType(payableType,id);
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
            payableTypeService.deletePayableType(id);
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
