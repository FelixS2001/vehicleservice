package com.vehicleservice.vehicleservice.dataservices;

import com.vehicleservice.vehicleservice.managers.VehicleDataManager;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.database.Vehicle;
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

    public List<VehicleResource> readVehicles(VehicleDTO vehicleDTO)
    {
        List<VehicleResource> vehicleResources = new ArrayList<>();

        final String ALL = "all";
        final String AVAILABLE = "available";
        final String UNAVAILABLE = "unavailable";
        final String MAINTENANCE = "maintenance";

        final String CAR = "car";
        final String TRUCK = "truck";
        final String BIKE = "bike";

        String state = vehicleDTO.getState();
        String type = vehicleDTO.getType();
        if((state != null) && (state == ALL || state == AVAILABLE || state == UNAVAILABLE || state == MAINTENANCE)
            && (type != null) && (type == ALL || type == CAR || type == TRUCK || type == BIKE))
        {

            for(Vehicle v : vehicleDataManager.readVehicles(state, type)){
                vehicleResources.add(convertEntryToResource(v));
            }
        }


        return vehicleResources;
    }

    public List<CustomerResource> readCustomers() {
        return null;
    }

    public StateResource createRent(RentDTO rentDTO) {
        vehicleDataManager.addRent(rentDTO);
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

    private VehicleResource convertEntryToResource(Vehicle vehicle) {
        VehicleResource vehicleResource = new VehicleResource();

        vehicleResource.setVehicle_id(vehicle.getVehicleID());
        vehicleResource.setVehicleName(vehicle.getName());
        vehicleResource.setCarSerialNumber(vehicle.getSerialNumber());
        vehicleResource.setVehicleTypeId(vehicle.getVehicleType().getVehicleTypeID());
        vehicleResource.setVehicleProducerId(vehicle.getProducer().getProducerID());
        vehicleResource.setBelongingStoreId(vehicle.getStore().getStoreID());
        vehicleResource.setVehiclePower(vehicle.getPower());

        return vehicleResource;
    }
}
