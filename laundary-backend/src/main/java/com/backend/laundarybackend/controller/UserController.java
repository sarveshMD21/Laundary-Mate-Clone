package com.backend.laundarybackend.controller;

import com.backend.laundarybackend.dto.UserLogInDto;
import com.backend.laundarybackend.dto.UserSignUpDto;
import com.backend.laundarybackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpDto> AddUser(@RequestBody  UserSignUpDto userSignUpDto){
        UserSignUpDto savedUser=userService.saveUser(userSignUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UUID>LogInUser(@RequestBody UserLogInDto userLogInDto){
        UserSignUpDto loggedUer=userService.logInUser(userLogInDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedUer.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>DeleteUserByID(@PathVariable String id){
        boolean status=userService.deleteUserByID(id);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean>UpdateUserByID(@RequestBody UserSignUpDto userSignUpDto){
        boolean status=userService.updateUser(userSignUpDto);
        if(status){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserSignUpDto>GetUserByID(@PathVariable String id){
        UserSignUpDto userSignUpDto=userService.getUserByID(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(userSignUpDto);
    }
}
