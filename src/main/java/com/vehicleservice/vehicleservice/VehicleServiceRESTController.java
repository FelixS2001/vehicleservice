package com.vehicleservice.vehicleservice;

import com.vehicleservice.vehicleservice.dataservices.VehicleDataService;
import com.vehicleservice.vehicleservice.models.dtos.RentDTO;
import com.vehicleservice.vehicleservice.models.dtos.VehicleStateDTO;
import com.vehicleservice.vehicleservice.models.resources.*;
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

    @RequestMapping(value = "/stores/{storeID}", method = RequestMethod.GET)
    public StoreResource readStore(@PathVariable int storeID) {
        return vehicleDataService.readStore(storeID);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<VehicleResource> readAllVehicles() {
        return vehicleDataService.readAllVehicles();
    }

    @RequestMapping(value = "/vehicles/state/{state}", method = RequestMethod.GET)
    public List<VehicleResource> readVehicles(@PathVariable("state") String state) {
        return vehicleDataService.readVehicles(state);
    }

    @RequestMapping(value = "/vehicles/{vehicleID}", method = RequestMethod.GET)
    public VehicleResource readVehicle(@PathVariable("vehicleID") int vehicleID) {
        return vehicleDataService.readVehicle(vehicleID);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<CustomerResource> readCustomers() {
        return vehicleDataService.readCustomers();
    }

    @RequestMapping(value = "/customers/{lastName}", method = RequestMethod.GET)
    public CustomerResource readCustomer(@PathVariable String lastName) {
        return vehicleDataService.readCustomer(lastName);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public EmployeeResource readEmployee(@RequestParam String userName, @RequestParam String password) {
        return vehicleDataService.readEmployee(userName, password);
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
