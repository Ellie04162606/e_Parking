package com.oocl.eParking.exception;

import com.oocl.eParking.enums.OrderEnum;

public class OrderException extends RuntimeException {

  private final String message;

  public OrderException(OrderEnum orderEnum) {
    this.message = orderEnum.getMessage();
  }

  public String getMessage() {
    return message;
  }
}
