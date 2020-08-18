package com.oocl.eParking.service.impl;

import com.oocl.eParking.entity.ParkingLot;
import com.oocl.eParking.entity.ParkingPosition;
import com.oocl.eParking.repository.ParkingLotRepository;
import com.oocl.eParking.repository.ParkingPositionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CarPositionServiceImplTest {

  @Mock
  ParkingLotRepository parkingLotRepository;

  @Mock
  ParkingPositionRepository parkingPositionRepository;

  @InjectMocks
  CarPositionServiceImpl carPositionService;

  @Test
  void getAllParkingPosition() {
    //given
    ParkingLot parkingLot = new ParkingLot(1, 133, 22, 3, 2, "南方软件园停车场", 8, "珠海市香洲区");
    List<ParkingPosition> parkingPositionList = new ArrayList<>();
    parkingPositionList.add(new ParkingPosition(1, 1, 1, 0));
    parkingPositionList.add(new ParkingPosition(2, 1, 2, 0));
    parkingPositionList.add(new ParkingPosition(3, 1, 3, 1));
    Mockito.when(parkingPositionRepository.findAll()).thenReturn(parkingPositionList);

    //when
    List<ParkingPosition> allParkingPosition = carPositionService.getAllParkingPosition();

    //then
    assertEquals(parkingPositionList.size(), allParkingPosition.size());
  }

  @Test
  void reserveParkingPosition() {
    //given
    ParkingPosition parkingPosition = new ParkingPosition(1, 1, 11, 0);
    ParkingLot parkingLot = new ParkingLot(1, 133, 22, 11, 11, "南方软件园停车场", 8, "珠海市香洲区");
    Mockito.when(parkingPositionRepository.findById(any(Integer.class))).thenReturn(
        java.util.Optional.of(parkingPosition));
    Mockito.when(parkingLotRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.of(parkingLot));
    Mockito.when(parkingPositionRepository.save(any())).thenReturn(null);
    Mockito.when(parkingLotRepository.save(any())).thenReturn(null);

    //when
    carPositionService.reserveParkingPosition(1);

    //then
    verify(parkingLotRepository, times(1)).save(any(ParkingLot.class));
    verify(parkingPositionRepository, times(1)).save(any(ParkingPosition.class));
  }
}