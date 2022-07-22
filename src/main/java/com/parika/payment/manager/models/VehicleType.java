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
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "vehicle_Type_Desc_Eng")
    private String vehicleTypeDescEng;
    @Column(name = "vehicle_Type_Desc_Fr")
    private  String vehicleTypeDescFr;
    @Column(name = "vehicle_Type_Desc_Rw")
    private String vehicleTypeDescRw;
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
