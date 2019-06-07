package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "partner_workshop", catalog = "vehicleservice")
public class PartnerWorkshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_workshop_id")
    private Integer partnerWorkshopID;

    @Column(name = "partner_workshop_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "partnerWorkshop", fetch = FetchType.LAZY)
    private Set<Repairing> repairings;

    public PartnerWorkshop() {
    }

    public Integer getPartnerWorkshopID() {
        return partnerWorkshopID;
    }

    public void setPartnerWorkshopID(Integer partnerWorkshopID) {
        this.partnerWorkshopID = partnerWorkshopID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Repairing> getRepairings() {
        return repairings;
    }

    public void setRepairings(Set<Repairing> repairings) {
        this.repairings = repairings;
    }
}
