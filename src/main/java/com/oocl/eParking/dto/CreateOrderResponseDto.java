package com.oocl.eParking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateOrderResponseDto {
  private Integer id;
  private String orderNumber;
  private Integer carId;
  private Integer customerId;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "GMT+8")
  private Date createTime;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "GMT+8")
  private Date startTime;
  private String status;
  private Integer parkingPositionId;
  private String licenseNumber;
}
