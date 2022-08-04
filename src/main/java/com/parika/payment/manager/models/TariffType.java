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
@Table(name = "Tariff_Type")
public class TariffType extends BaseEntity{
    @Column(name="type_name")
    private String typeName;
    @Column(name="type_description")
    private String typeDescription;
}
