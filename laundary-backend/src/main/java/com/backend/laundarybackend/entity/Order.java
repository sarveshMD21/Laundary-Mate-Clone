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
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;
//    @ManyToOne
//    @JoinColumn(name="employee_id")
//    private Employee employee;
//    @Column(name="order_status")
//    private String orderStatus;
//    @Column(name="payment_method")
//    private String paymentMethod;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "order_cloth",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "cloth_id")
//    )
//    private List<Cloth> cloths;

}
