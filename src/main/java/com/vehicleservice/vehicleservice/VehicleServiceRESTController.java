package com.vehicleservice.vehicleservice;

import com.vehicleservice.vehicleservice.dataservices.VehicleDataService;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.database.Vehicle;
import com.vehicleservice.vehicleservice.models.dto.RentDTO;
import com.vehicleservice.vehicleservice.models.dto.VehicleDTO;
import com.vehicleservice.vehicleservice.models.dto.VehicleStateDTO;
import com.vehicleservice.vehicleservice.models.resource.CustomerResource;
import com.vehicleservice.vehicleservice.models.resource.StateResource;
import com.vehicleservice.vehicleservice.models.resource.StoreResource;
import com.vehicleservice.vehicleservice.models.resource.VehicleResource;
import com.vehicleservice.vehicleservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicleservice")
public class VehicleServiceRESTController {

    @Autowired
    private VehicleDataService vehicleDataService;

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<StoreResource> readStores(){
        return vehicleDataService.readStores();
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<VehicleResource> readVehicles(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleDataService.readVehicles(vehicleDTO);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<CustomerResource> readCustomers() {
        return vehicleDataService.readCustomers();
    }

    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public StateResource createRent(@RequestBody RentDTO rentDTO) {
        return vehicleDataService.createRent(rentDTO);
    }

    @RequestMapping(value = "/state", method = RequestMethod.PUT)
    public StateResource updateVehicleState(@RequestBody VehicleStateDTO vehicleStateDTO) {
        return vehicleDataService.updateVehicleState(vehicleStateDTO);
    }
}
