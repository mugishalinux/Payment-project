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
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "Chassis_No")
    private String chassisNo;
    @JoinColumn(name = "Plate_NO")
    private String plateNo;
    @ManyToOne
    @JoinColumn(name = "Brand_id")
    private VehicleBrand vehicleBrand;
    @ManyToOne
    @JoinColumn(name = "Model_id")
    private VehicleModel vehicleModel;
    @ManyToOne
    @JoinColumn(name = "Vehicle_type_id")
    private VehicleType vehicleType;
    @Column(name = "Front_Photo_Url")
    private String frontPhotoUrl;
    @Column(name = "Side_Photo_Url")
    private String sidePhotoUrl;
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
