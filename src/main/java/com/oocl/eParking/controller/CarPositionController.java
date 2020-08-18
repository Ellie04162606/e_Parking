package com.oocl.eParking.controller;

import com.oocl.eParking.entity.ParkingPosition;
import com.oocl.eParking.service.CarPositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarPositionController {

  private final CarPositionService carPositionService;

  public CarPositionController(CarPositionService carPositionService) {
    this.carPositionService = carPositionService;
  }

  @GetMapping("/parking_position/{parkingLotId}")
  List<ParkingPosition> getAllParkingPosition(@PathVariable int parkingLotId) {
    return carPositionService.getAllParkingPosition(parkingLotId);
  }

  @PutMapping("/parking_position/{parkingPositionId}")
  void reserveParkingPosition(@PathVariable int parkingPositionId) {
    carPositionService.reserveParkingPosition(parkingPositionId);
  }
}
