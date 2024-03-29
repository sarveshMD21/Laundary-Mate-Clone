package com.backend.laundarybackend.service;

import com.backend.laundarybackend.dto.UserLogInDto;
import com.backend.laundarybackend.dto.UserSignUpDto;
import com.backend.laundarybackend.entity.User;

public interface UserService {
     UserSignUpDto saveUser(UserSignUpDto userSignUpDto);

     UserSignUpDto logInUser(UserLogInDto userLogInDto);

     User getUserByUserName(String username);

     boolean deleteUserByID(String id);

    UserSignUpDto getUserByID(String id);

    boolean updateUser(UserSignUpDto userSignUpDto);
}
