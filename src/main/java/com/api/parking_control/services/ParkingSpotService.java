package com.api.parking_control.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

public Page<ParkingSpot> findAll(Pageable pageable) {
    return parkingSpotRepository.findAll(pageable);
}

public Optional<ParkingSpot> findById(UUID id) {
    return parkingSpotRepository.findById(id);
}

@Transactional
public void delete(ParkingSpot parkingSpot) {
     parkingSpotRepository.delete(parkingSpot);
}

}
