package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.ClothDto;
import com.backend.laundarybackend.entity.Cloth;
import lombok.Getter;


public class ClothMapper {
    public static Cloth MapToClothEntity(ClothDto clothDto){
        return new Cloth(
                clothDto.getId(),
                clothDto.getClothName(),
                clothDto.getCost(),
                clothDto.isWashAllowed(),
                clothDto.getImageData()
        );
    }

    public static ClothDto MapToClothDto(Cloth cloth){
        return new ClothDto(
          cloth.getId(),
          cloth.getClothName(),
          cloth.getCost(),
          cloth.getWashAllowed(),
          cloth.getClothImage()
        );
    }
}
