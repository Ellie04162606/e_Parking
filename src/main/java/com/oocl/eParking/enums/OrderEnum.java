package com.oocl.eParking.enums;

public enum OrderEnum {
  THIS_CAR_HAS_BEEN_RESERVED("This car has been reserved");
  private final String message;

  OrderEnum(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
