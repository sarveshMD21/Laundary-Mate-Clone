package com.backend.laundarybackend.controller;

import com.backend.laundarybackend.dto.AddressDto;
import com.backend.laundarybackend.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<UUID>SaveAddress(@RequestBody AddressDto addressDto){
        UUID addressUUID=addressService.saveAddress(addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressUUID);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto>getAddressById(@PathVariable String id){
        AddressDto addressDto=addressService.getAddressById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(addressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>deleteAddressById(@PathVariable String id){
        boolean status=addressService.deleteAddressById(id);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }


    @PutMapping
    public ResponseEntity<Boolean>updateAddress(@RequestBody AddressDto addressDto){
        boolean status=addressService.updateAddress(addressDto);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}

