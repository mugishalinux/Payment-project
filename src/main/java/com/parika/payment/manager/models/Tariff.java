package com.parika.payment.manager.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "Tariff")
public class Tariff extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "tariff_type_id")
    private TariffType tariffTypeId;
    @Column(name = "type_name")
    private String tariffName;
    @Column(name = "unit_duration")
    private int unitDuration;
}
