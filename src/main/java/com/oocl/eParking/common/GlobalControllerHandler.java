package com.oocl.eParking.common;

import com.oocl.eParking.exception.ParkingLotException;
import com.oocl.eParking.exception.UserException;
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

  @ExceptionHandler(UserException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  String userException(UserException userException) {
    return userException.getMessage();
  }

}
