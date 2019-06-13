package com.vehicleservice.vehicleservice.models.resources;

public class VehicleResource {

    private Integer vehicleID;
    private String vehicleName;
    private String carSerialNumber;
    private Integer vehicleTypeID;
    private String vehicleTypeName;
    private Integer vehicleProducerID;
    private String vehicleProducerName;
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

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public Integer getVehicleProducerID() {
        return vehicleProducerID;
    }

    public void setVehicleProducerID(Integer vehicleProducerID) {
        this.vehicleProducerID = vehicleProducerID;
    }

    public String getVehicleProducerName() {
        return vehicleProducerName;
    }

    public void setVehicleProducerName(String vehicleProducerName) {
        this.vehicleProducerName = vehicleProducerName;
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
