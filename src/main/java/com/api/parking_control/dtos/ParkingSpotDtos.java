package com.api.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;

public class ParkingSpotDtos {
    @NotBlank
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
}
