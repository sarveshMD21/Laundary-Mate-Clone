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
public class UserSignUpDto {
    private UUID id;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String emailAddress;
    private UUID activeAddress;
}
