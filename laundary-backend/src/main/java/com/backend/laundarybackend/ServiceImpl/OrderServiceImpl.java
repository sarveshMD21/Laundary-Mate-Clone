package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.dto.OrderDto;
import com.backend.laundarybackend.entity.Order;
import com.backend.laundarybackend.mapper.OrderMapper;
import com.backend.laundarybackend.repository.OrderRepository;
import com.backend.laundarybackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public UUID createOrder(OrderDto orderDto) {
        Order order=orderRepository.save(OrderMapper.MaptoOrderEntity(orderDto));
        return order.getId();
    }

    @Override
    public OrderDto getOrderById(String id) {
        UUID savedId=UUID.fromString(id);
        if(orderRepository.existsById(savedId)) {
            Optional<Order> orderOptional = orderRepository.findById(savedId);
            Order order = orderOptional.get();
            return OrderMapper.MaptoOrderDto(order);
        }
        else{
            throw new RuntimeException("The order does not exsist");
        }
    }

    @Override
    public boolean deleteOrderById(String id) {
        UUID savedId=UUID.fromString(id);
        if(orderRepository.existsById(savedId)){
            orderRepository.deleteById(savedId);
            return true;
        }
        else{
            throw new RuntimeException("The order does not exsist");
        }
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        UUID savedId=orderDto.getId();
        if(orderRepository.existsById(savedId)){
            Order updateOrder=orderRepository.save(OrderMapper.MaptoOrderEntity(orderDto));
            return OrderMapper.MaptoOrderDto(updateOrder);
        }
        else{
            throw new RuntimeException("The order does not exsist");
        }
    }
}
