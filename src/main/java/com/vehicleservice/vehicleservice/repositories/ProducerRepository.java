package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
