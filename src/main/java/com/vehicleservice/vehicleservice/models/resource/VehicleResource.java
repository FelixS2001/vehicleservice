package com.vehicleservice.vehicleservice.models.resource;

public class VehicleResource {

    private Integer vehicleID;
    private String vehicleName;
    private String carSerialNumber;
    private Integer vehicleTypeID;
    private Integer vehicleProducerID;
    private Integer belongingStoreID;
    private Integer vehiclePower;

    public VehicleResource() {
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getCarSerialNumber() {
        return carSerialNumber;
    }

    public void setCarSerialNumber(String carSerialNumber) {
        this.carSerialNumber = carSerialNumber;
    }

    public Integer getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Integer vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getVehicleProducerID() {
        return vehicleProducerID;
    }

    public void setVehicleProducerID(Integer vehicleProducerID) {
        this.vehicleProducerID = vehicleProducerID;
    }

    public Integer getBelongingStoreID() {
        return belongingStoreID;
    }

    public void setBelongingStoreID(Integer belongingStoreID) {
        this.belongingStoreID = belongingStoreID;
    }

    public Integer getVehiclePower() {
        return vehiclePower;
    }

    public void setVehiclePower(Integer vehiclePower) {
        this.vehiclePower = vehiclePower;
    }
}
