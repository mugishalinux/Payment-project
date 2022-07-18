package com.parika.payment.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticketId;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "initiated_by")
    private String initiatedBy;
    @Column(name = "paid_by")
    private String paidBy;
    @ManyToOne
    @JoinColumn(name = "payable_type_id")
    private PayableType payableType;
    @Column(name = "payable_reference")
    private String payableReference;
    @Column(name = "external_payment_ref")
    private String externalPaymentReference;
    @Column(name = "creation_time")
    private LocalTime creationTime;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
