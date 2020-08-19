package com.oocl.eParking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDto {

  @NotBlank
  private String carNumber;

  @NotNull
  private Integer carId;

  @NotNull
  private Integer customerId;

  @NotNull
  private Date startTime;

  @NotNull
  private Integer parkingPositionId;
}
