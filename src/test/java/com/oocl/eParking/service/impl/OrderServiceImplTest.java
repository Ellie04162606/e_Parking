package com.oocl.eParking.service.impl;

import com.oocl.eParking.dto.CreateOrderRequestDto;
import com.oocl.eParking.dto.CreateOrderResponseDto;
import com.oocl.eParking.entity.Order;
import com.oocl.eParking.enums.OrderStatus;
import com.oocl.eParking.repository.OrderRepository;
import com.oocl.eParking.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

  @Mock
  OrderRepository orderRepository;

  @InjectMocks
  OrderServiceImpl orderService;

  @Test
  void should_return_order_info_when_create_oder_given_create_order_dto() {
    //given
    int orderId = 1;
    int carId = 2;
    int customerId = 3;
    Date createTime = new Date();
    Date startTime = new Date();
    String orderStatus = OrderStatus.RESERVED;
    int parkingPositionId = 5;
    String carNumber = "X66666";

    Order order = new Order(orderId, carId, customerId, createTime, startTime, orderStatus, parkingPositionId);
    Mockito.when(orderRepository.save(any(Order.class))).thenReturn(order);
    CreateOrderRequestDto createOrderRequestDto = new CreateOrderRequestDto(carNumber, carId, customerId, startTime,
        parkingPositionId);

    //when
    CreateOrderResponseDto responseDto = orderService.createOrder(createOrderRequestDto);

    //them
    assertEquals(carId, responseDto.getCarId());
  }
}