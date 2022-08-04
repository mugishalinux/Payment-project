package com.parika.payment.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "payable_type")
public class PayableType extends BaseEntity{
    @Column(name="payable_type_desc")
    private String payableTypeDesc;
}
