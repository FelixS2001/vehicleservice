package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Repairing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairingRepository extends JpaRepository<Repairing, Integer> {
}
