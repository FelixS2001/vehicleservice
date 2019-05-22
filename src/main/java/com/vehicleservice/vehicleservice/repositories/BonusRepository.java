package com.vehicleservice.vehicleservice.repositories;

import com.vehicleservice.vehicleservice.models.database.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, Integer> {
}
