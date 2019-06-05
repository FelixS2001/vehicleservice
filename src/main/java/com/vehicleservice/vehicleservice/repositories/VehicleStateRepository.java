package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.VehicleState;
import com.vehicleservice.vehicleservice.models.database.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VehicleStateRepository extends JpaRepository<VehicleState, Integer> {
    VehicleState findByName(String stateName);
}
