package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producer", catalog = "vehicleservice")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "producer_id")
    private Integer producerID;

    @Column(name = "producer_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "producer")
    private Set<Vehicle> vehicles;

    public Producer() {
    }

    public Integer getProducerID() {
        return producerID;
    }

    public void setProducerID(Integer producerID) {
        this.producerID = producerID;
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
