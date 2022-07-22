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
@Table(name = "Parking_Slot")
public class ParkingSlot{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "parking_area_id")
    private ParkingArea parkingAreaId;
    @Column(name = "slot_name")
    private String slotName;
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "parking_start_time")
    private LocalTime parkingStartTime;
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
