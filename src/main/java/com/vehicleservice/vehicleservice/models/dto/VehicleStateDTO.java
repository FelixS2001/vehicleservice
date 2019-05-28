package com.vehicleservice.vehicleservice.models.dto;

public class VehicleStateDTO {

    private Integer vehicleID;
    private String state;

    public VehicleStateDTO() {
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
