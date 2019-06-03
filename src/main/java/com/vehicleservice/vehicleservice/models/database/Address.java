package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;

@Entity
@Table(name = "address", catalog = "vehicleservice")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressID;

    @Column(name = "address_street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Customer customer;

    public Address() {
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
