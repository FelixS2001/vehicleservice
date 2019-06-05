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


    public List<Store> readStores() {
        return storeRepository.findAll();
    }

    public List<Vehicle> readVehicles() {
        return vehicleRepository.findAll(); //placeholder
    }

    public List<Customer> readCustomers() {
        return customerRepository.findAll();
    }

    public RentedVehicle createRent(int customerID, int vehicleID, int employeeID, Date startDate, Date endDate ) {

        Customer customer = customerRepository.findById(customerID).get();

        Vehicle vehicle = vehicleRepository.findById(vehicleID).get();

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

    public Vehicle updateVehicleState() {
        return vehicleRepository.findAll().get(0); //placeholder
    }
}
