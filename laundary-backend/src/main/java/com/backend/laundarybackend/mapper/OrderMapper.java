package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.ClothDto;
import com.backend.laundarybackend.dto.OrderDto;
import com.backend.laundarybackend.entity.Cloth;
import com.backend.laundarybackend.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderDto MaptoOrderDto(Order order){

        return new OrderDto(
                order.getId(),
                order.getCost(),
                order.getUserId(),
                order.getEmployeeId(),
                order.getOrderStatus(),
                order.getPaymentMethod(),
                order.getClothList()
        );

    }

    public static Order MaptoOrderEntity(OrderDto orderDto){

        return new Order(
                orderDto.getId(),
                orderDto.getCost(),
                orderDto.getUserId(),
                orderDto.getEmployeeId(),
                orderDto.getOrderStatus(),
                orderDto.getPaymentMethod(),
                orderDto.getClothList()
        );
    }

}
