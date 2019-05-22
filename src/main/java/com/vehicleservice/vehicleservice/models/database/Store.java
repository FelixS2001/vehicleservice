package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;

@Entity
@Table(name = "store", catalog = "vehicleservice")
public class Store {

    @Id
    @Column(name = "store_id")
    private Integer storeID;

    @Column(name = "store_name")
    private String storeName;

    public Store() {
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
