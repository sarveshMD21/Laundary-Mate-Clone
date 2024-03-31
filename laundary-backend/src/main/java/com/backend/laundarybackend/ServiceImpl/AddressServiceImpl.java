package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.dto.AddressDto;
import com.backend.laundarybackend.entity.Address;
import com.backend.laundarybackend.mapper.AddressMapper;
import com.backend.laundarybackend.repository.AddressRepository;
import com.backend.laundarybackend.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public UUID saveAddress(AddressDto addressDto) {
        Address address=addressRepository.save(AddressMapper.MaptoAddressEntity(addressDto));
        return address.getId();
    }

    @Override
    public AddressDto getAddressById(String id) {
        if(addressRepository.existsById(UUID.fromString(id))){
            Optional<Address>addressOptional=addressRepository.findById(UUID.fromString(id));
            Address address=addressOptional.orElse(null);
            if(address!=null)
               return AddressMapper.MaptoAddressDto(address);
        }
        else{
            throw new RuntimeException("The Address does not exsist for this id");
        }
        return null;
    }

    @Override
    public boolean deleteAddressById(String id) {
        if(addressRepository.existsById(UUID.fromString(id))){
            addressRepository.deleteById(UUID.fromString(id));
            return true;
        }
        else{
            throw new RuntimeException("The address does not exsits for this id");
        }
    }

    @Override
    public boolean updateAddress(AddressDto addressDto) {
        if(addressRepository.existsById(addressDto.getId())){
            addressRepository.save(AddressMapper.MaptoAddressEntity(addressDto));
            return true;
        }
        else{
            throw new RuntimeException("The address does not exsits for this id");
        }
    }
}
