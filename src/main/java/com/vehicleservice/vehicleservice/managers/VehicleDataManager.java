package com.vehicleservice.vehicleservice.managers;

import com.vehicleservice.vehicleservice.models.database.*;
import com.vehicleservice.vehicleservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.vehicleservice.vehicleservice.dataservices.VehicleDataService.STATE_UNAVAILABLE;

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

    public List<Store> readStores() {
        return storeRepository.findAll();
    }

    public List<Vehicle> readAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> readVehicles(String state) {
        return vehicleRepository.findByVehicleStateName(state);
    }

    public List<Customer> readCustomers() {
        return customerRepository.findAll();
    }

    public RentedVehicle createRent(int customerID, int vehicleID, int employeeID, Date startDate, Date endDate) {
        Customer customer = customerRepository.findById(customerID).get();
        System.out.println("Street: " + customer.getAddress().getStreet());
        Vehicle vehicle = vehicleRepository.findById(vehicleID).get();
        VehicleState vehicleState = vehicleStateRepository.findByName(STATE_UNAVAILABLE);
        Employee employee = employeeRepository.findById(employeeID).get();

        vehicle.setVehicleState(vehicleState);

        RentedVehicle rentedVehicle = new RentedVehicle();
        rentedVehicle.setVehicle(vehicle);
        rentedVehicle.setCustomer(customer);
        rentedVehicle.setEmployee(employee);
        rentedVehicle.setStore(vehicle.getStore());
        rentedVehicle.setStartDate(startDate);
        rentedVehicle.setEndDate(endDate);
        rentedVehicleRepository.save(rentedVehicle);

        return rentedVehicle;
    }

    public Vehicle updateVehicleState(Integer vehicleID, String stateName) {
        Vehicle vehicle = vehicleRepository.findById(vehicleID).get();
        VehicleState vehicleState = vehicleStateRepository.findByName(stateName);

        vehicle.setVehicleState(vehicleState);
        vehicleStateRepository.save(vehicleState);

        return vehicle;
    }
}
