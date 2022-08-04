package com.parika.payment.manager.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "vehicle_brand")
public class VehicleBrand extends BaseEntity{
    @Column(name = "Brand_Desc")
    private String brandDesc;
}
