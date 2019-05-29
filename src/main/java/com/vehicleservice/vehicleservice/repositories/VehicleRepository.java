package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
   // List<Vehicle> findByStateAndType(String state, String type);
}
