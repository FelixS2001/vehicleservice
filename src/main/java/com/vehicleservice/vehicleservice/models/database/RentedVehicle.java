package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rented_vehicle", catalog = "vehicleservice")
public class RentedVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rented_id")
    private Integer rentedVehicleID;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rented_vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rented_store_id", referencedColumnName = "store_id")
    private Store store;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rented_employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rented_customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public RentedVehicle() {
    }

    public Integer getRentedVehicleID() {
        return rentedVehicleID;
    }

    public void setRentedVehicleID(Integer rentedVehicleID) {
        this.rentedVehicleID = rentedVehicleID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
