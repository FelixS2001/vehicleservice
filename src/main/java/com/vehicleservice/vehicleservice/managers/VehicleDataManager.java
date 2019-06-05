package com.vehicleservice.vehicleservice.managers;

import com.vehicleservice.vehicleservice.models.database.Customer;
import com.vehicleservice.vehicleservice.models.database.RentedVehicle;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.database.Vehicle;
import com.vehicleservice.vehicleservice.repositories.CustomerRepository;
import com.vehicleservice.vehicleservice.repositories.RentedVehicleRepository;
import com.vehicleservice.vehicleservice.repositories.StoreRepository;
import com.vehicleservice.vehicleservice.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleDataManager {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentedVehicleRepository rentedVehicleRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Store> readStores() {
        return storeRepository.findAll();
    }

    public List<Vehicle> readVehicles(String state) {
        return vehicleRepository.findByVehicleStateName(state); //placeholder
    }

    public List<Customer> readCustomers() {
        return customerRepository.findAll();
    }

    public RentedVehicle createRent() {
        return rentedVehicleRepository.findAll().get(0); //placeholder
    }

    public Vehicle updateVehicleState() {
        return vehicleRepository.findAll().get(0); //placeholder
    }
}
