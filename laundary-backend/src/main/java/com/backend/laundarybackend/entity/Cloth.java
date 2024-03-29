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
@Table(name="cloth")
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="cloth_name")
    private String clothName;
    @Column(name="cost")
    private int Cost;
    @Column(name="wash_allowed")
    private Boolean washAllowed;
    @Lob
    @Column(name="cloth_image")
    private byte[] clothImage;
}
