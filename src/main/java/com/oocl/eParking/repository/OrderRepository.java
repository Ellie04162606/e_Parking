package com.oocl.eParking.repository;

import com.oocl.eParking.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
  Integer countByCarIdAndStatus(int carId,String status);
}
