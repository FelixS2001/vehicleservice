package com.vehicleservice.vehicleservice.models.dto;

import java.util.List;

public class VehicleDTO {

    private List<String> states;
    private List<String> types;

    public VehicleDTO() {
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
