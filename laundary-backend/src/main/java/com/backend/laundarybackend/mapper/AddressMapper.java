package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.AddressDto;
import com.backend.laundarybackend.entity.Address;

public class AddressMapper {
    public static Address MaptoAddressEntity(AddressDto addressDto){
        return new Address(
                addressDto.getId(),
                addressDto.getStreetName(),
                addressDto.getFlatName(),
                addressDto.getRoomNo(),
                addressDto.getCity(),
                addressDto.getPinCode(),
                addressDto.getEntityID()
        );
    }

    public static  AddressDto MaptoAddressDto(Address address){
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getFlat(),
                address.getRoomNo(),
                address.getCity(),
                address.getPinCode(),
                address.getEntityID()
        );
    }

}
