package com.parika.payment.manager.controller;

import com.parika.payment.manager.models.PayableType;
import com.parika.payment.manager.services.PayableTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment/payableType")
public class PayableTypeController {
    private PayableTypeService payableTypeService;

    public PayableTypeController(PayableTypeService payableTypeService) {
        super();
        this.payableTypeService = payableTypeService;
    }
    @ApiOperation(value="Create a Payable Type")
    @PostMapping("")
    public ResponseEntity< PayableType> createPayableType(@RequestBody  PayableType payableType){
        return new ResponseEntity< PayableType>(payableTypeService.createPayableType(payableType), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Payable Type")
    @GetMapping()
    List< PayableType> getAllPayableType(){
        return payableTypeService.getAllPayableType();
    }

    @ApiOperation(value="Retrieve single Payable Type by using ID")
    @GetMapping("/{id}")
    public PayableType getPayableTypeById(@PathVariable("id") int id){
        return payableTypeService.getSinglePayableType(id);
    }
    @ApiOperation(value="Update a Payable Type by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<PayableType> updatePayableType(@RequestBody PayableType payableType, @PathVariable("id") int id){
        return new ResponseEntity<PayableType>(payableTypeService.updatePayableType(payableType,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Payable Type by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingArea(@PathVariable("id") int id){
        payableTypeService.deletePayableType(id);
        return new ResponseEntity<String>("Payable Type deletion successfully!!!",HttpStatus.OK);
    }
}
