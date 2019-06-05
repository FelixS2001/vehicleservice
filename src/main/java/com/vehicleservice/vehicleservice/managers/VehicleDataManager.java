package com.vehicleservice.vehicleservice.managers;

import com.vehicleservice.vehicleservice.models.database.*;
import com.vehicleservice.vehicleservice.models.dto.RentDTO;
import com.vehicleservice.vehicleservice.repositories.*;
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

    public RentedVehicle createRent(RentDTO rentDTO) {

        Customer customer = customerRepository.findById(rentDTO.getCustomerID()).get();

        Vehicle vehicle = vehicleRepository.findById(rentDTO.getVehicleID()).get();

        Employee employee = employeeRepository.findById(rentDTO.getEmployeeID()).get();

        RentedVehicle rentedVehicle = new RentedVehicle();
        rentedVehicle.setVehicle(vehicle);
        rentedVehicle.setCustomer(customer);
        rentedVehicle.setEmployee(employee);
        rentedVehicle.setStore(vehicle.getStore());
        rentedVehicle.setStartDate(rentDTO.getStartDate());
        rentedVehicle.setEndDate(rentDTO.getEndDate());

        rentedVehicleRepository.save(rentedVehicle);

        return rentedVehicle; //placeholder
    }

    public Vehicle updateVehicleState() {
        return vehicleRepository.findAll().get(0); //placeholder
    }
}
