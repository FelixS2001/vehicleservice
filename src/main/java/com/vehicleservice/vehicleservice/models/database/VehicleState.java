package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_state", catalog = "vehicleservice")
public class VehicleState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_state_id")
    private Integer vehicleStateID;

    @Column(name = "state_name ", nullable = false)
    private String name;

    @OneToOne(mappedBy = "vehicleState", fetch = FetchType.LAZY)
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
