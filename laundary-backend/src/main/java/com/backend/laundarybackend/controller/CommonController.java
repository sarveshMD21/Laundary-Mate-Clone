package com.backend.laundarybackend.controller;


import com.backend.laundarybackend.dto.EmailDto;
import com.backend.laundarybackend.dto.PasswordDto;
import com.backend.laundarybackend.dto.PhoneNumberDto;
import com.backend.laundarybackend.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CommonController {

    private final CommonService commonService;
    @PostMapping("/password")
    public ResponseEntity<String>checkPassword(@RequestBody PasswordDto passwordDto) throws IOException {
        String status=commonService.checkPasswordOfUser(passwordDto.getPassword());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
    }
    @PostMapping ("/phonenumber")
    public ResponseEntity<String>checkNumber(@RequestBody PhoneNumberDto phoneNumberDto){
        String status=commonService.checkNumber(phoneNumberDto.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
    }

    @PostMapping("/phonenumber/verify")
    public ResponseEntity<String>verifyNumber(@RequestBody PhoneNumberDto phoneNumberDto){
        String otpCode=commonService.verifyNumber(phoneNumberDto.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(otpCode);
    }

    @PostMapping("/email")
    public ResponseEntity<String>checkEmail(@RequestBody EmailDto emailDto){
        String status=commonService.checkEmail(emailDto.getEmailId());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
    }

}
