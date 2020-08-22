package com.oocl.eParking.exception;

import com.oocl.eParking.enums.UserEnum;

public class UserException extends RuntimeException{

  private final String message;

  public UserException(UserEnum userEnum){
    this.message =userEnum.getMessage();
  }

  @Override
  public String getMessage() {
    return message;
  }
}
