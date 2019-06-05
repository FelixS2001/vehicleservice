package com.vehicleservice.vehicleservice.managers;

import com.vehicleservice.vehicleservice.models.database.*;
import com.vehicleservice.vehicleservice.models.dto.RentDTO;
import com.vehicleservice.vehicleservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VehicleStateRepository vehicleStateRepository;

    private final String STATE_UNAVAILABLE = "unavailable";

    public List<Store> readStores() {
        return storeRepository.findAll();
    }

    public List<Vehicle> readAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> readVehicles(String state) {
        return vehicleRepository.findByVehicleStateName(state); //placeholder
    }

    public List<Customer> readCustomers() {
        return customerRepository.findAll();
    }

    public RentedVehicle createRent(int customerID, int vehicleID, int employeeID, Date startDate, Date endDate ) {

        Customer customer = customerRepository.findById(customerID).get();

        Vehicle vehicle = vehicleRepository.findById(vehicleID).get();
        VehicleState vehicleState = vehicleStateRepository.findByName(STATE_UNAVAILABLE);
        vehicle.setVehicleState(vehicleState);

        Employee employee = employeeRepository.findById(employeeID).get();

        RentedVehicle rentedVehicle = new RentedVehicle();
        rentedVehicle.setVehicle(vehicle);
        rentedVehicle.setCustomer(customer);
        rentedVehicle.setEmployee(employee);
        rentedVehicle.setStore(vehicle.getStore());
        rentedVehicle.setStartDate(startDate);
        rentedVehicle.setEndDate(endDate);

        rentedVehicleRepository.save(rentedVehicle);

        return rentedVehicle; //placeholder
    }

    public Vehicle updateVehicleState(Integer vehicleID, String stateName) {

        Vehicle vehicle  = vehicleRepository.findById(vehicleID).get();
        VehicleState vehicleState = vehicleStateRepository.findByName(stateName);


        vehicle.setVehicleState(vehicleState);
        vehicleStateRepository.save(vehicleState);

        return vehicle; //placeholder
    }
}
