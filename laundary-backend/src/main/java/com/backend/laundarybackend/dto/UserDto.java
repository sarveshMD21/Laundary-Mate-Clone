package com.backend.laundarybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String emailAdderess;
    private List<AddressDto> addressList;

}
