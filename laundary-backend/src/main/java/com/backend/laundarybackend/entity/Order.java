package com.backend.laundarybackend.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name="order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="order_cost")
    private int cost;
    @Column(name="user_id")
    private UUID userId;
    @Column(name="employee_id")
    private UUID employeeId;
    @Column(name="order_status")
    private String orderStatus;
    @Column(name="payment_method")
    private String paymentMethod;
    @Column(name="cloth_id_array")
    private UUID[] clothList;

}
