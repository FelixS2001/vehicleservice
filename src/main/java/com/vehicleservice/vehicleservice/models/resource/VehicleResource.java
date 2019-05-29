package com.vehicleservice.vehicleservice.models.resource;

public class  VehicleResource {

    private Integer vehicle_id;
    private String vehicleName;
    private Integer carSerialNumber;
    private Integer vehicleTypeId;
    private Integer vehicleProducerId;
    private Integer belongingStoreId;
    private Integer vehiclePower;

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Integer getCarSerialNumber() {
        return carSerialNumber;
    }

    public void setCarSerialNumber(Integer carSerialNumber) {
        this.carSerialNumber = carSerialNumber;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Integer getVehicleProducerId() {
        return vehicleProducerId;
    }

    public void setVehicleProducerId(Integer vehicleProducerId) {
        this.vehicleProducerId = vehicleProducerId;
    }

    public Integer getBelongingStoreId() {
        return belongingStoreId;
    }

    public void setBelongingStoreId(Integer belongingStoreId) {
        this.belongingStoreId = belongingStoreId;
    }

    public Integer getVehiclePower() {
        return vehiclePower;
    }

    public void setVehiclePower(Integer vehiclePower) {
        this.vehiclePower = vehiclePower;
    }
}
