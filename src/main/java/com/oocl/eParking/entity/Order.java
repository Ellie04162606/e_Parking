package com.oocl.eParking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer carId;
  private Integer customerId;
  private Date createTime;
  private Date startTime;
  private Date endTime;
  private Integer totalCost;
  private Integer preCost;
  private String status;
  private Integer parkingPositionId;
  private Date enterTime;

  public Order(Integer id, Integer carId, Integer customerId, Date createTime, Date startTime, String status,
      Integer parkingPositionId) {
    this.id = id;
    this.carId = carId;
    this.customerId = customerId;
    this.createTime = createTime;
    this.startTime = startTime;
    this.status = status;
    this.parkingPositionId = parkingPositionId;
  }
}
