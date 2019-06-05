package com.vehicleservice.vehicleservice.models.resource;

public class StateResource {

    private Integer stateCode;
    private String stateMessage;


    public StateResource(Integer stateCode, String stateMessage){
        this.stateCode = stateCode;
        this.stateMessage = stateMessage;
    }

    public StateResource(){

    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }
}
