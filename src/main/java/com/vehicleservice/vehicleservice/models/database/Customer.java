package com.vehicleservice.vehicleservice.models.database;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer", catalog = "vehicleservice")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerID;

    @Column(name = "customer_firstname")
    private String firstName;

    @Column(name = "customer_lastname")
    private String lastName;

    @Column(name = "customer_phone_number")
    private Integer phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<RentedVehicle> rentedVehicles;

    public Customer() {
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<RentedVehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(Set<RentedVehicle> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }
}
