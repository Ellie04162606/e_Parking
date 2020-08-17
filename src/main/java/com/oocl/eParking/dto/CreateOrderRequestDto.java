package com.oocl.eParking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDto {

  @NotBlank
  private String carNumber;

  @NotBlank
  private Integer carId;

  @NotBlank
  private Integer customerId;

  @NotBlank
  private Date startTime;

  @NotBlank
  private Integer parkingPositionId;
}
