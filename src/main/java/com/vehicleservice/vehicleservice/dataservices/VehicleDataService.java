package com.vehicleservice.vehicleservice.dataservices;

import com.vehicleservice.vehicleservice.managers.VehicleDataManager;
import com.vehicleservice.vehicleservice.models.database.Customer;
import com.vehicleservice.vehicleservice.models.database.RentedVehicle;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.dto.RentDTO;
import com.vehicleservice.vehicleservice.models.dto.VehicleDTO;
import com.vehicleservice.vehicleservice.models.dto.VehicleStateDTO;
import com.vehicleservice.vehicleservice.models.resource.CustomerResource;
import com.vehicleservice.vehicleservice.models.resource.StateResource;
import com.vehicleservice.vehicleservice.models.resource.StoreResource;
import com.vehicleservice.vehicleservice.models.resource.VehicleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VehicleDataService {

    @Autowired
    private VehicleDataManager vehicleDataManager;

    public List<StoreResource> readStores() {
        List<StoreResource> storeResources = new ArrayList<>();

        vehicleDataManager.readStores()
                .forEach(store -> storeResources.add(convertEntryToResource(store)));

        return storeResources;
    }

    public List<VehicleResource> readVehicles(VehicleDTO vehicleDTO) {
        vehicleDataManager.readVehicles();
        return null;
    }

    public List<CustomerResource> readCustomers() {
        List<CustomerResource> customerResources = new ArrayList<>();

        vehicleDataManager.readCustomers()
                .forEach(customer -> customerResources.add(convertEntryToResource(customer)));

        return customerResources;
    }

    public StateResource createRent(RentDTO rentDTO) {
        vehicleDataManager.createRent(rentDTO.getCustomerID(), rentDTO.getVehicleID(),rentDTO.getEmployeeID(), rentDTO.getStartDate(),rentDTO.getEndDate());
        StateResource resource = new StateResource(100, "OK");
        return resource;
    }

    public StateResource updateVehicleState(VehicleStateDTO vehicleStateDTO) {
        vehicleDataManager.updateVehicleState();
        return null;
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
}
