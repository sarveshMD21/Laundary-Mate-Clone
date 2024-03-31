package com.backend.laundarybackend.controller;

import com.backend.laundarybackend.dto.OrderDto;
import com.backend.laundarybackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<UUID>createOrder(@RequestBody OrderDto orderDto){
        UUID savedId=orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto>getOrderById(@PathVariable String id){
        OrderDto orderDto=orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteOrderById(@PathVariable String id){
        boolean status=orderService.deleteOrderById(id);
        if(status){
            return  ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping
    public ResponseEntity<OrderDto>updateOrder(@RequestBody OrderDto orderDto){
        OrderDto updatedOrder=orderService.updateOrder(orderDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedOrder);
    }

}
