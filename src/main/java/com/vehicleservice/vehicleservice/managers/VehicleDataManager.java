package com.vehicleservice.vehicleservice.managers;

import com.vehicleservice.vehicleservice.models.database.*;
import com.vehicleservice.vehicleservice.models.dto.RentDTO;
import com.vehicleservice.vehicleservice.models.resource.CustomerResource;
import com.vehicleservice.vehicleservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleDataManager {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PartnerWorkshopRepository partnerWorkshopRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private RentedVehicleRepository rentedVehicleRepository;

    @Autowired
    private RepairingRepository repairingRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<Store> readStores() {
        return storeRepository.findAll();
    }

    public List<Vehicle> readVehicles(String state, String type){
       //return vehicleRepository.findByStateAndType(state, type);
        return null;
    };

    public void addRent(RentDTO rentDTO){

        Customer customer = customerRepository.findById(rentDTO.getCustomerID()).get();
        Vehicle vehicle = vehicleRepository.findById(rentDTO.getVehicleID()).get();
        Employee employee = employeeRepository.findById(rentDTO.getEmployeeID()).get();
        Store store = employee.getStore();

        RentedVehicle rentedVehicle = new RentedVehicle();
        rentedVehicle.setCustomer(customer);
        rentedVehicle.setVehicle(vehicle);
        rentedVehicle.setStore(store);
        rentedVehicle.setStartDate(rentDTO.getStartDate());
        rentedVehicle.setEndDate(rentDTO.getEndDate());

        rentedVehicleRepository.save(rentedVehicle);
    }
}
