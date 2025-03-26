package com.api.parking_control.services;

import java.util.List;

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

public boolean existsByLicensePlateCar(String licensePlateCar) {
    
    return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
   
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
}

public boolean existsByApartmentAndBlock(String apartment, String block) {
    
    return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
}

public List<ParkingSpot> findAll() {
  
    return parkingSpotRepository.findAll();
}

}
