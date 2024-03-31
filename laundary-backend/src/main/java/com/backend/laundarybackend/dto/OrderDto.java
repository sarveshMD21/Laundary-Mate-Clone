package com.backend.laundarybackend.dto;


import com.backend.laundarybackend.entity.Cloth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID id;
    private int cost;
    private UUID userId;
    private UUID employeeId;
    private String orderStatus;
    private String paymentMethod;
    private UUID[] clothList;


}
