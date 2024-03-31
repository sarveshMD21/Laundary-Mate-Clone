package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.dto.ClothDto;
import com.backend.laundarybackend.entity.Cloth;
import com.backend.laundarybackend.mapper.ClothMapper;
import com.backend.laundarybackend.repository.ClothRepository;
import com.backend.laundarybackend.service.ClothService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClothServiceImpl implements ClothService {
    private final ClothRepository clothRepository;

    @Override
    public UUID createCloth(ClothDto clothDto) {
      Cloth savedCloth=clothRepository.save(ClothMapper.MapToClothEntity(clothDto));
      return savedCloth.getId();
    }

    @Override
    public ClothDto getClothById(String id) {
       UUID clothId=UUID.fromString(id);
       if(clothRepository.existsById(clothId)){
           Optional<Cloth>clothOptional=clothRepository.findById(clothId);
           ClothDto clothDto=ClothMapper.MapToClothDto(clothOptional.get());
           return clothDto;
       }
       return null;
    }

    @Override
    public ClothDto updateCloth(ClothDto clothDto) {
        UUID clothid=clothDto.getId();
        if(clothRepository.existsById(clothid)){
            Optional<Cloth>clothOptional=clothRepository.findById(clothid);
            ClothDto savedCloth=ClothMapper.MapToClothDto(clothOptional.get());
            savedCloth.setClothName(clothDto.getClothName());
            savedCloth.setWashAllowed(clothDto.isWashAllowed());
            savedCloth.setCost(clothDto.getCost());
            Cloth updatedCloth=clothRepository.save(ClothMapper.MapToClothEntity(savedCloth));
            return ClothMapper.MapToClothDto(updatedCloth);
        }
        else{
            throw  new RuntimeException("No such Cloth present");
        }

    }

    @Override
    public boolean deleteClothById(String id) {
        UUID clothId=UUID.fromString(id);
        if(clothRepository.existsById(clothId)){
            clothRepository.deleteById(clothId);
            return true;
        }
        else{
            throw  new RuntimeException("No such Cloth present");
        }
    }

    @Override
    public List<ClothDto> getAllCloths() {
        List<Cloth>savedCloth=clothRepository.findAll();
        List<ClothDto>savedClothDto=new ArrayList<>();
        for(Cloth cl:savedCloth){
            savedClothDto.add(ClothMapper.MapToClothDto(cl));
        }
        return savedClothDto;
    }


}
