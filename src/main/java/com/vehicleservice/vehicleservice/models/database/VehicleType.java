package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle_type", catalog = "vehicleservice")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id")
    private Integer vehicleTypeID;

    @Column(name = "vehicle_type_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "vehicleType", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

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

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
