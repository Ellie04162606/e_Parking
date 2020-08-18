package com.oocl.eParking.repository;

import com.oocl.eParking.entity.ParkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingPositionRepository extends JpaRepository<ParkingPosition,Integer> {
  List<ParkingPosition> findByParkingLotId(int parkingLotId);
}
