package com.oocl.eParking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parking_position")
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPosition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "parkinglot_id")
  private ParkingLot parkingLot;

  private int parkingNumber;
  private int status;

}
