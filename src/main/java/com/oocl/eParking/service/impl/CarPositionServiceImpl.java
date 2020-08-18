package com.oocl.eParking.service.impl;

import com.oocl.eParking.entity.ParkingLot;
import com.oocl.eParking.entity.ParkingPosition;
import com.oocl.eParking.enums.ParkingLotEnum;
import com.oocl.eParking.exception.ParkingLotException;
import com.oocl.eParking.repository.ParkingLotRepository;
import com.oocl.eParking.repository.ParkingPositionRepository;
import com.oocl.eParking.service.CarPositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class CarPositionServiceImpl implements CarPositionService {

  private final ParkingPositionRepository parkingPositionRepository;
  private final ParkingLotRepository parkingLotRepository;

  public CarPositionServiceImpl(ParkingPositionRepository parkingPositionRepository,
      ParkingLotRepository parkingLotRepository) {
    this.parkingPositionRepository = parkingPositionRepository;
    this.parkingLotRepository = parkingLotRepository;
  }

  @Override
  public List<ParkingPosition> getAllParkingPosition() {
    return parkingPositionRepository.findAll();
  }

  @Override
  @Transactional
  public void reserveParkingPosition(int parkingPositionId) {
    ParkingPosition parkingPosition = parkingPositionRepository.findById(parkingPositionId)
        .orElseThrow(() -> new ParkingLotException(ParkingLotEnum.PARKING_POSITION_NOT_FOUND));
    ParkingLot parkingLot = parkingLotRepository.findById(parkingPosition.getParkingLotId())
        .orElseThrow(() -> new ParkingLotException(ParkingLotEnum.PARKING_LOT_NOT_FOUND));
    parkingLot.setCapacity(parkingLot.getCapacity() - 1);
    parkingLot.setRemainingAmount(parkingLot.getRemainingAmount() - 1);
    parkingLotRepository.save(parkingLot);
    parkingPosition.setStatus(1);
    parkingPositionRepository.save(parkingPosition);
  }
}
