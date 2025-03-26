package com.api.parking_control.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking_control.dtos.ParkingSpotDtos;
import com.api.parking_control.models.ParkingSpot;
import com.api.parking_control.services.ParkingSpotService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<ParkingSpot> saveParkingSpot(@RequestBody @Valid ParkingSpotDtos parkingSpotDtos) {
        
        
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDtos.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDtos.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDtos.getApartment(), parkingSpotDtos.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        var parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDtos, parkingSpot);
        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpot));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpot>>getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }
}
