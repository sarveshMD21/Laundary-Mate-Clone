package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.dto.UserLogInDto;
import com.backend.laundarybackend.dto.UserSignUpDto;
import com.backend.laundarybackend.entity.User;
import com.backend.laundarybackend.exception.DuplicateEntityException;
import com.backend.laundarybackend.mapper.UserMapper;
import com.backend.laundarybackend.repository.UserRepository;
import com.backend.laundarybackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserSignUpDto saveUser(UserSignUpDto userSignUpDto) {
        if(userRepository.existsByUserName(userSignUpDto.getUserName())){
            throw new DuplicateEntityException("username already exists");
        }
        else if(userRepository.existsByPhoneNumber(userSignUpDto.getPhoneNumber())){
            throw new DuplicateEntityException("phone number already exists");
        }
        else if(userRepository.existsByEmailAddress(userSignUpDto.getEmailAddress())){
            throw new DuplicateEntityException("email address already exists");
        }
        String hashedPassword=passwordEncoder.encode(userSignUpDto.getUserPassword());
        userSignUpDto.setUserPassword(hashedPassword);
        User user= UserMapper.MapptoUserEntity(userSignUpDto);
        User savedUser=userRepository.save(user);
        return UserMapper.MapptoUserDto(savedUser);
    }

    @Override
    public UserSignUpDto logInUser(UserLogInDto userLogInDto) {
        if(!userRepository.existsByUserName(userLogInDto.getUserName())){
            throw new DuplicateEntityException("The Entered User Name does not exists");
        }
        User savedUser=getUserByUserName(userLogInDto.getUserName());
        if(!passwordEncoder.matches(userLogInDto.getUserPassword(),savedUser.getUserPassword())){
            throw new DuplicateEntityException("The Password entered is incorrect");
        }

        return UserMapper.MapptoUserDto(savedUser);
    }

    @Override
    public User getUserByUserName(String username) {
        Optional<User>user=userRepository.findByUserName(username);
        if(user.isPresent())
          return user.get();
        return null;
    }

    @Override
    public boolean deleteUserByID(String id) {
        if(userRepository.existsById(UUID.fromString(id))){
            userRepository.deleteById(UUID.fromString(id));
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public UserSignUpDto getUserByID(String id) {
        if(userRepository.existsById(UUID.fromString(id))){
            Optional<User>userOptional=userRepository.findById(UUID.fromString(id));
            if(userOptional.isPresent()){
           return UserMapper.MapptoUserDto(userOptional.get());
            }
        }
        else{
            throw new RuntimeException("The User is not present");
        }
        return null;
    }

    @Override
    public boolean updateUser(UserSignUpDto userSignUpDto) {
        if(userRepository.existsById(userSignUpDto.getId())){
            User user=UserMapper.MapptoUserEntity(userSignUpDto);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
