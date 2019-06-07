package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "repairing", catalog = "vehicleservice")
public class Repairing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repairing_id")
    private Integer repairingID;

    @Column(name = "repairing_date", nullable = false)
    private Date date;

    @Column(name = "repairing_description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "repairing_partner_workshop_id", referencedColumnName = "partner_workshop_id")
    private PartnerWorkshop partnerWorkshop;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "repairing_vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    public Repairing() {
    }

    public Integer getRepairingID() {
        return repairingID;
    }

    public void setRepairingID(Integer repairingID) {
        this.repairingID = repairingID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PartnerWorkshop getPartnerWorkshop() {
        return partnerWorkshop;
    }

    public void setPartnerWorkshop(PartnerWorkshop partnerWorkshop) {
        this.partnerWorkshop = partnerWorkshop;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
