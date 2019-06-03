package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_type", catalog = "vehicleservice")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_type_id")
    private Integer vehicleTypeID;

    @Column(name = "vehicle_type_name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "vehicleType", fetch = FetchType.LAZY)
    private Vehicle vehicle;

    public VehicleType() {
    }

    public Integer getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Integer vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
