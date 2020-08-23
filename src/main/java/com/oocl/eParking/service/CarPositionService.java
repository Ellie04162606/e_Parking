package com.oocl.eParking.service;

import com.oocl.eParking.entity.ParkingLot;
import com.oocl.eParking.entity.ParkingPosition;

import java.util.List;
import java.util.Optional;

public interface CarPositionService {
  List<ParkingPosition> getAllParkingPosition(int parkingLotId);

  ParkingLot reserveParkingPosition(int parkingPositionId);

  ParkingLot cancelParkingPosition(int parkingLotId);

}
