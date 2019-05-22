package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
