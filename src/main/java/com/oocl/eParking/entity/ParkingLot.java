package com.oocl.eParking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkinglot")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingLot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private double latitude;
  private double longitude;
  private int capacity;
  @Column(name = "remaining_amount")
  private int remainingAmount;
  private String name;

  @Column(name = "unit_price")
  private int unitPrice;
  private String location;


}
