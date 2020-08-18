package com.oocl.eParking.service;

import com.oocl.eParking.entity.ParkingPosition;

import java.util.List;

public interface CarPositionService {
  List<ParkingPosition> getAllParkingPosition();

  void reserveParkingPosition(int parkingPositionId);

}
