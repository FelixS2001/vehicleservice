package com.vehicleservice.vehicleservice;

import com.vehicleservice.vehicleservice.models.Store;
import com.vehicleservice.vehicleservice.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicleservice")
public class VehicleServiceRESTController {

    @Autowired
    private StoreRepository storeRepository;

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public List<Store> readStores(){
        return storeRepository.findAll();
    }
}
