package com.vehicleservice.vehicleservice.dataservices;

import com.vehicleservice.vehicleservice.exceptions.InvalidBodyException;
import com.vehicleservice.vehicleservice.exceptions.OperationFailedException;
import com.vehicleservice.vehicleservice.managers.VehicleDataManager;
import com.vehicleservice.vehicleservice.models.database.Customer;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.database.Vehicle;
import com.vehicleservice.vehicleservice.models.dtos.RentDTO;
import com.vehicleservice.vehicleservice.models.dtos.VehicleStateDTO;
import com.vehicleservice.vehicleservice.models.resources.CustomerResource;
import com.vehicleservice.vehicleservice.models.resources.StateResource;
import com.vehicleservice.vehicleservice.models.resources.StoreResource;
import com.vehicleservice.vehicleservice.models.resources.VehicleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDataService {

    public static final String STATE_AVAILABLE = "available";
    public static final String STATE_UNAVAILABLE = "unavailable";
    public static final String STATE_MAINTENANCE = "maintenance";

    @Autowired
    private VehicleDataManager vehicleDataManager;

    public List<StoreResource> readStores() {
        List<StoreResource> storeResources = new ArrayList<>();

        vehicleDataManager.readStores()
                .forEach(store -> storeResources.add(convertEntryToResource(store)));

        return storeResources;
    }

    public List<VehicleResource> readAllVehicles() {
        List<VehicleResource> vehicleResources = new ArrayList<>();

        vehicleDataManager.readAllVehicles()
                .forEach(vehicle -> vehicleResources.add(convertEntryToResource(vehicle)));

        return vehicleResources;
    }

    public List<VehicleResource> readVehicles(String state) {
        checkState(state);

        List<VehicleResource> vehicleResources = new ArrayList<>();

        vehicleDataManager.readVehicles(state)
                .forEach(vehicle -> vehicleResources.add(convertEntryToResource(vehicle)));

        return vehicleResources;
    }

    public List<CustomerResource> readCustomers() {
        List<CustomerResource> customerResources = new ArrayList<>();

        vehicleDataManager.readCustomers()
                .forEach(customer -> customerResources.add(convertEntryToResource(customer)));

        return customerResources;
    }

    public StateResource createRent(RentDTO rentDTO) {
        checkDTO(rentDTO);

        try {
            vehicleDataManager.createRent(rentDTO.getCustomerID(), rentDTO.getVehicleID(), rentDTO.getEmployeeID(),
                    rentDTO.getStartDate(), rentDTO.getEndDate());
            return new StateResource(200, "Rent was created successfully");
        } catch (Exception e) {
            throw new OperationFailedException(String.format("Rent could not be created. %s",
                    e.getMessage()));
        }
    }

    public StateResource updateVehicleState(VehicleStateDTO vehicleStateDTO) {
        checkDTO(vehicleStateDTO);
        checkState(vehicleStateDTO.getState());

        try {
            vehicleDataManager.updateVehicleState(vehicleStateDTO.getVehicleID(), vehicleStateDTO.getState());
            return new StateResource(200, "State was updated successfully");
        } catch (Exception e) {
            throw new OperationFailedException(String.format("State could not be updated. %s",
                    e.getMessage()));
        }
    }

    //Checkers
    private void checkState(String state) {
        if (!state.equals(STATE_AVAILABLE) && !state.equals(STATE_UNAVAILABLE) && !state.equals(STATE_MAINTENANCE)) {
            throw new InvalidBodyException(String.format("The state %s is invalid", state));
        }
    }

    private void checkDTO(RentDTO rentDTO) {
        if (rentDTO.getCustomerID() == null ||
                rentDTO.getVehicleID() == null ||
                rentDTO.getEmployeeID() == null ||
                rentDTO.getStartDate() == null ||
                rentDTO.getEndDate() == null) {
            throw new InvalidBodyException("The object must not contain null values");
        }
    }

    private void checkDTO(VehicleStateDTO vehicleStateDTO) {
        if (vehicleStateDTO.getVehicleID() == null ||
                vehicleStateDTO.getState() == null) {
            throw new InvalidBodyException("The object must not contain null values");
        }
    }

    //Converters
    private StoreResource convertEntryToResource(Store store) {
        StoreResource storeResource = new StoreResource();

        storeResource.setName(store.getName());

        return storeResource;
    }

    private CustomerResource convertEntryToResource(Customer customer) {
        CustomerResource customerResource = new CustomerResource();

        customerResource.setCustomerID(customer.getCustomerID());
        customerResource.setFirstName(customer.getFirstName());
        customerResource.setLastName(customer.getLastName());
        customerResource.setStreet(customer.getAddress().getStreet());
        customerResource.setZipcode(customer.getAddress().getZipcode());

        return customerResource;
    }

    private VehicleResource convertEntryToResource(Vehicle vehicle) {
        VehicleResource vehicleResource = new VehicleResource();

        vehicleResource.setVehicleID(vehicle.getVehicleID());
        vehicleResource.setVehicleName(vehicle.getName());
        vehicleResource.setCarSerialNumber(vehicle.getSerialNumber());
        vehicleResource.setVehicleTypeID(vehicle.getVehicleType().getVehicleTypeID());
        vehicleResource.setVehicleTypeName(vehicle.getVehicleType().getName());
        vehicleResource.setVehicleProducerID(vehicle.getProducer().getProducerID());
        vehicleResource.setVehicleProducerName(vehicle.getProducer().getName());
        vehicleResource.setBelongingStoreID(vehicle.getStore().getStoreID());
        vehicleResource.setVehiclePower(vehicle.getPower());

        return vehicleResource;
    }
}
