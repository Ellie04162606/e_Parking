package com.oocl.eParking.service;


import com.oocl.eParking.dto.CreateOrderRequestDto;
import com.oocl.eParking.dto.CreateOrderResponseDto;

public interface OrderService {
  CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);
}
