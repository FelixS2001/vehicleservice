package com.vehicleservice.vehicleservice.models.dto;

public class VehicleDTO {

    private String state;
    private String type;

    public VehicleDTO() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
