package com.vehicleservice.vehicleservice.dataservices;

import com.vehicleservice.vehicleservice.managers.VehicleDataManager;
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
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleDataService {

    @Autowired
    private VehicleDataManager vehicleDataManager;

    public List<StoreResource> readStores() {
        List<StoreResource> storeResources = new ArrayList<>();

        for (Store s : vehicleDataManager.readStores()) {
            storeResources.add(convertEntryToResource(s));
        }

        return storeResources;
    }

    public List<VehicleResource> readVehicles(VehicleDTO vehicleDTO) {
        return null;
    }

    public List<CustomerResource> readCustomers() {
        return null;
    }

    public StateResource createRent(RentDTO rentDTO) {
        return null;
    }

    public StateResource updateVehicleState(VehicleStateDTO vehicleStateDTO) {
        return null;
    }

    private StoreResource convertEntryToResource(Store store) {
        StoreResource storeResource = new StoreResource();

        storeResource.setName(store.getName());

        return storeResource;
    }
}
