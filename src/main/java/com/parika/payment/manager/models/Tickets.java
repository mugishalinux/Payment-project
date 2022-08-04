package com.parika.payment.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "tickets")
public class Tickets extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "parking_slot_id")
    private ParkingSlot parkingSlot;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;
    @Column(name="payment_reference")
    private String paymentReference;
    @Column(name="initiated_by")
    private String initiatedBy;
}
