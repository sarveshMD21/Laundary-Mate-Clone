package com.backend.laundarybackend.service;


import com.backend.laundarybackend.dto.OrderDto;

import java.util.UUID;

public interface OrderService {
    UUID createOrder(OrderDto orderDto);

    OrderDto getOrderById(String id);

    boolean deleteOrderById(String id);

    OrderDto updateOrder(OrderDto orderDto);
}
