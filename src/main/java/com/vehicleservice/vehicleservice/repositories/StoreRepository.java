package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
