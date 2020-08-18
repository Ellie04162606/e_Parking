package com.oocl.eParking.controller;

import com.oocl.eParking.dto.CreateOrderRequestDto;
import com.oocl.eParking.dto.CreateOrderResponseDto;
import com.oocl.eParking.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/orders")
  public CreateOrderResponseDto createOrder(@RequestBody @Valid CreateOrderRequestDto createOrderRequestDto) {
    return orderService.createOrder(createOrderRequestDto);
  }
}
