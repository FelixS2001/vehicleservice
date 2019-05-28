package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.PartnerWorkshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PartnerWorkshopRepository extends JpaRepository<PartnerWorkshop, Integer> {
}
