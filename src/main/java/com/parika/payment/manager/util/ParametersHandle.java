package com.parika.payment.manager.util;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class ParametersHandle {
    private int id;
    private int paymentTypeId;
    private int ticketId;
    private double amountPaid;
    private String initiatedBy;
    private String paidBy;
    private int payableTypeId;
    private String payableReference;
    private String externalPaymentReference;
    private LocalTime creationTime;
    private int statusId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
