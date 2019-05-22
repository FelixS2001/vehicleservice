package com.vehicleservice.vehicleservice;

import com.vehicleservice.vehicleservice.dataservices.VehicleDataService;
import com.vehicleservice.vehicleservice.models.database.Store;
import com.vehicleservice.vehicleservice.models.database.Vehicle;
import com.vehicleservice.vehicleservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicleservice")
public class VehicleServiceRESTController {

    @Autowired
    private VehicleDataService vehicleDataService;


    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BonusRepository bonusRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PartnerWorkshopRepository partnerWorkshopRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ProducerPartnerWorkshopRepository producerPartnerWorkshopRepository;

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


    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<Store> readStores(){
        return vehicleDataService.readStores();
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<Vehicle> readVehicles() {
        return vehicleDataService.readVehicles();
    }

//    GET: alle Filialen
//    GET: alle Fahrzeuge (state: verfügbar, nicht verfügbar, wartung)
//    GET: Fahrzeuge (type: PKW, LKW, Motorrad)
//    POST/PUT/GET???: Mieten Kunde, Fahrzeug, Mitarbeiter, Datum(von-bis))
//    PUT: Status des Fahrzeuges ändern
//    PUT: zurückgeben
//    GET: für Anmeldung

}
