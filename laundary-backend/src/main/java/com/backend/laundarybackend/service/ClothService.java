package com.backend.laundarybackend.service;

import com.backend.laundarybackend.dto.ClothDto;

import java.util.List;
import java.util.UUID;

public interface ClothService {
    UUID createCloth(ClothDto clothDto);

    ClothDto getClothById(String id);

    ClothDto updateCloth(ClothDto clothDto);

    boolean deleteClothById(String id);

    List<ClothDto> getAllCloths();
}
