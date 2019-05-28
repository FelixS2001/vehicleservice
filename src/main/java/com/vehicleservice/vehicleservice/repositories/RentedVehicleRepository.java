package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.RentedVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RentedVehicleRepository extends JpaRepository<RentedVehicle, Integer> {
}
