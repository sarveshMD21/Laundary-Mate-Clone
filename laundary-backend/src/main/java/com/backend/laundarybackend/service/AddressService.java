package com.backend.laundarybackend.service;

import com.backend.laundarybackend.dto.AddressDto;

import java.util.UUID;

public interface AddressService {
    UUID saveAddress(AddressDto addressDto);

    AddressDto getAddressById(String id);

    boolean deleteAddressById(String id);

    boolean updateAddress(AddressDto addressDto);
}
