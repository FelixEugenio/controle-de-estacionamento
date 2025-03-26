package com.api.parking_control.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parking_control.models.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
    
}
