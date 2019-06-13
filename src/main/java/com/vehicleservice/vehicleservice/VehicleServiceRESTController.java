package com.vehicleservice.vehicleservice;

import com.vehicleservice.vehicleservice.dataservices.VehicleDataService;
import com.vehicleservice.vehicleservice.models.dtos.RentDTO;
import com.vehicleservice.vehicleservice.models.dtos.VehicleStateDTO;
import com.vehicleservice.vehicleservice.models.resources.CustomerResource;
import com.vehicleservice.vehicleservice.models.resources.StateResource;
import com.vehicleservice.vehicleservice.models.resources.StoreResource;
import com.vehicleservice.vehicleservice.models.resources.VehicleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicleservice")
@CrossOrigin
public class VehicleServiceRESTController {

    @Autowired
    private VehicleDataService vehicleDataService;

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<StoreResource> readStores() {
        return vehicleDataService.readStores();
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<VehicleResource> readAllVehicles() {
        return vehicleDataService.readAllVehicles();
    }

    @RequestMapping(value = "/vehicles/{state}", method = RequestMethod.GET)
    public List<VehicleResource> readVehicles(@PathVariable("state") String state) {
        return vehicleDataService.readVehicles(state);
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
