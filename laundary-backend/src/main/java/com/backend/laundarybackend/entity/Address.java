package com.backend.laundarybackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address_table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="street")
    private String street;
    @Column(name="flat_name")
    private String Flat;
    @Column(name="roomNo")
    private Long roomNo;
    @Column(name="city")
    private String city;
    @Column(name="pinCode")
    private Long pinCode;
    @Column(name="entity_id")
    private UUID entityID;
}
