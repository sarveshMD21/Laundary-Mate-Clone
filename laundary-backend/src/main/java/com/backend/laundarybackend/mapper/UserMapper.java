package com.backend.laundarybackend.mapper;

import com.backend.laundarybackend.dto.UserSignUpDto;
import com.backend.laundarybackend.entity.User;

public class UserMapper {
    public static User MapptoUserEntity(UserSignUpDto userSignUpDto){
        return new User(userSignUpDto.getId(),userSignUpDto.getUserName(),userSignUpDto.getUserPassword(),userSignUpDto.getPhoneNumber(),
                userSignUpDto.getEmailAddress(),userSignUpDto.getActiveAddress());
    }

    public static UserSignUpDto MapptoUserDto(User user){
        return new UserSignUpDto(
                user.getId(),
                user.getUserName(),
                user.getUserPassword(),
                user.getPhoneNumber(),
                user.getEmailAddress(),
                user.getCurrentActiveAddressID()
        );
    }

}
