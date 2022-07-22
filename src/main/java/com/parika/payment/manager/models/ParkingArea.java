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
@Table(name = "Parking_Area")
public class ParkingArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "parking_name")
    private String parkingName;
    @ManyToOne
    @JoinColumn(name = "village_code")
    private Village village;
    @Column(name="street_name")
    private String streetName;
    private String latitude;
    private String longitude;
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
