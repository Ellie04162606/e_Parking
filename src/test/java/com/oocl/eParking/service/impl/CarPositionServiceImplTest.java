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