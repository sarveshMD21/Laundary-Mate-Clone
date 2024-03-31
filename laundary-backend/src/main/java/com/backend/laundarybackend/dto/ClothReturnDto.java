package com.backend.laundarybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClothReturnDto {
    private UUID id;
    private String clothName;
    private int Cost;
    private boolean washAllowed;
    private byte[] ImageBinaryData;
}
