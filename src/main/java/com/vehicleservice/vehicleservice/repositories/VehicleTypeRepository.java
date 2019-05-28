package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
