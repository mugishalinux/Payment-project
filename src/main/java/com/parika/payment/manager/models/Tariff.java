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
@Table(name = "Tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "tariff_type_id")
    private TariffType tariffTypeId;
    @Column(name = "type_name")
    private String tariffName;
    @Column(name = "unit_duration")
    private int unitDuration;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on_at")
    private LocalDateTime createdOnDt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "update_by_dt")
    private LocalDateTime updatedByDt;
}
