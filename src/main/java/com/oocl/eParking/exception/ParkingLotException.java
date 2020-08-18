package com.oocl.eParking.exception;

import com.oocl.eParking.enums.ParkingLotEnum;

public class ParkingLotException extends RuntimeException {

  private final String message;


  public ParkingLotException(ParkingLotEnum parkingLotEnum) {
    this.message = parkingLotEnum.getMessage();
  }

  @Override
  public String getMessage() {
    return message;
  }
}
