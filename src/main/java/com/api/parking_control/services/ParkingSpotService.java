package com.api.parking_control.services;

import org.springframework.stereotype.Service;

import com.api.parking_control.models.ParkingSpot;
import com.api.parking_control.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
    
  final  ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpot save(ParkingSpot parkingSpot) {
    return parkingSpotRepository.save(parkingSpot);
  }

}
