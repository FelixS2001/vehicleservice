package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
