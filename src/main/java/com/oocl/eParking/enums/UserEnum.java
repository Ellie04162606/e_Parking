package com.oocl.eParking.enums;

public enum UserEnum {
  USER_NOT_FOUND("User not found");
  private final String message;

  UserEnum(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
