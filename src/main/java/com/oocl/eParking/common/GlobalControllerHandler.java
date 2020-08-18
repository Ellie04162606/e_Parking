package com.oocl.eParking.common;

import com.oocl.eParking.exception.ParkingLotException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerHandler {

  @ExceptionHandler(ParkingLotException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  String parkingLotException(ParkingLotException parkingLotException) {
    return parkingLotException.getMessage();
  }

}