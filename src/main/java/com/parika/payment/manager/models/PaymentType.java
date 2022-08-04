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
@Table(name = "payment_type")
public class PaymentType extends BaseEntity{
    @Column(name="payment_type_desc")
    private String paymentTypeDesc;
}
