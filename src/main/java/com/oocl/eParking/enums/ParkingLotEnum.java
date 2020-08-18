package com.oocl.eParking.enums;

public enum ParkingLotEnum {

  PARKING_POSITION_NOT_FOUND("Parking position not found"),
  PARKING_LOT_NOT_FOUND("Parking lot not found"),
  PARKING_POSITION_IS_NOT_EMPTY("Parking position is not empty");

  private final String message;

  ParkingLotEnum(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
