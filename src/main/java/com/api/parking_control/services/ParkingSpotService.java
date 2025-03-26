package com.api.parking_control.services;

import org.springframework.stereotype.Service;

import com.api.parking_control.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
    
  final  ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  
}
