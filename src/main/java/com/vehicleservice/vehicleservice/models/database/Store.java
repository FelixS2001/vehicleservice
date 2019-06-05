package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store", catalog = "vehicleservice")
public class Store {

    @Id
    @Column(name = "store_id")
    private Integer storeID;

    @Column(name = "store_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private Set<RentedVehicle> rentedVehicles;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    public Store() {
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<RentedVehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(Set<RentedVehicle> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
