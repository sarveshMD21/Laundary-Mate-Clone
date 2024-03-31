package com.backend.laundarybackend.controller;


import com.backend.laundarybackend.dto.ClothDto;
import com.backend.laundarybackend.entity.Cloth;
import com.backend.laundarybackend.service.ClothService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cloth")
public class ClothController {
    private final ClothService clothService;

    @PostMapping
    public ResponseEntity<UUID>createCloth(@RequestParam("file") MultipartFile file,
                                           @RequestParam("clothName") String clothName,
                                           @RequestParam("cost") int cost,
                                           @RequestParam("washAllowed") boolean washAllowed) throws IOException {
        byte [] data=file.getBytes();
        ClothDto clothDto=new ClothDto();
        clothDto.setClothName(clothName);
        clothDto.setCost(cost);
        clothDto.setImageData(data);
        clothDto.setWashAllowed(washAllowed);
        UUID savedId=clothService.createCloth(clothDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothDto>getClothById(@PathVariable String id){
        ClothDto clothDto=clothService.getClothById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(clothDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteClothById(@PathVariable String id){
        boolean status=clothService.deleteClothById(id);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PutMapping
    public ResponseEntity<ClothDto>updateCloth(@RequestBody ClothDto clothDto){
        ClothDto updatedCloth=clothService.updateCloth(clothDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCloth);
    }

    @GetMapping
    public ResponseEntity<List<ClothDto>>getAllCloths(){
        List<ClothDto>clothList=clothService.getAllCloths();
        return ResponseEntity.status(HttpStatus.FOUND).body(clothList);
    }
}
