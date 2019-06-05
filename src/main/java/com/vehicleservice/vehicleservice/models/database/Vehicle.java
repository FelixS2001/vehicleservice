package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle", catalog = "vehicleservice")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Integer vehicleID;

    @Column(name = "vehicle_name", nullable = false)
    private String name;

    @Column(name = "car_serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "vehicle_power", nullable = false)
    private Integer power;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_type_id", referencedColumnName = "vehicle_type_id")
    private VehicleType vehicleType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_state_id", referencedColumnName = "vehicle_state_id")
    private VehicleState vehicleState;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_producer_id", referencedColumnName = "producer_id")
    private Producer producer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "belonging_store_id", referencedColumnName = "store_id")
    private Store store;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<RentedVehicle> rentedVehicles;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<Repairing> repairs;

    public Vehicle() {
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<RentedVehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(Set<RentedVehicle> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public Set<Repairing> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repairing> repairs) {
        this.repairs = repairs;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }
}
