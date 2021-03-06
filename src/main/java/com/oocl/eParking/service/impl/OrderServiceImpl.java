package com.oocl.eParking.service.impl;

import com.oocl.eParking.dto.CreateOrderRequestDto;
import com.oocl.eParking.dto.CreateOrderResponseDto;
import com.oocl.eParking.entity.Order;
import com.oocl.eParking.enums.OrderEnum;
import com.oocl.eParking.enums.OrderStatus;
import com.oocl.eParking.exception.OrderException;
import com.oocl.eParking.repository.OrderRepository;
import com.oocl.eParking.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  @Override
  public CreateOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
    Integer count = orderRepository.countByCarIdAndStatus(createOrderRequestDto.getCarId(), OrderStatus.RESERVED);
    if (Objects.nonNull(count) && count > 0) {
      throw new OrderException(OrderEnum.THIS_CAR_HAS_BEEN_RESERVED);
    }
    Order orderToSave = Order.builder().carId(createOrderRequestDto.getCarId())
        .customerId(createOrderRequestDto.getCustomerId())
        .createTime(new Date())
        .startTime(createOrderRequestDto.getStartTime())
        .status(OrderStatus.RESERVED)
        .parkingPositionId(createOrderRequestDto.getParkingPositionId())
        .build();
    Order orderSaved = orderRepository.save(orderToSave);

    CreateOrderResponseDto response = new CreateOrderResponseDto();
    BeanUtils.copyProperties(orderSaved, response);
    response.setOrderNumber(String.valueOf(orderSaved.getId()) + orderSaved.getCustomerId() + orderSaved.getCarId());
    response.setLicenseNumber(createOrderRequestDto.getCarNumber());

    return response;
  }
}
