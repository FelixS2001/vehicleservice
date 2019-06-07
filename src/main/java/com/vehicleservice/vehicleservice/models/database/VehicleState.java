package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle_state", catalog = "vehicleservice")
public class VehicleState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_state_id")
    private Integer vehicleStateID;

    @Column(name = "state_name ", nullable = false)
    private String name;

    @OneToMany(mappedBy = "vehicleState", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

    public VehicleState() {
    }

    public Integer getVehicleStateID() {
        return vehicleStateID;
    }

    public void setVehicleStateID(Integer vehicleStateID) {
        this.vehicleStateID = vehicleStateID;
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
