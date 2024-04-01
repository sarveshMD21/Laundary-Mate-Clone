package com.backend.laundarybackend.ServiceImpl;

import com.backend.laundarybackend.config.ApiConfig;
import com.backend.laundarybackend.dto.SmsDto;
import com.backend.laundarybackend.repository.EmployeeRepository;
import com.backend.laundarybackend.repository.UserRepository;
import com.backend.laundarybackend.service.CommonService;
import com.enzoic.client.Enzoic;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final UserRepository userRepository;
    private  final EmployeeRepository employeeRepository;
    private final Enzoic enzoic;
    private final RestTemplate restTemplate;



    @Override
    public String checkPasswordOfUser(String password) throws IOException {
        if(password.isEmpty()){
            return "Do not give empty password";
        }
        else if(password.length()<10){
            return "Password length more than 10 accepted";
        }
        else if(password.length()>15)
            return"Password length not more than 15";
        else if(enzoic.CheckPassword(password)){
            return "Password is compromised do not use";
        }
        else if(password.chars().anyMatch(Character::isWhitespace)){
            return "Do not include whitespace";
        }

        int specialCount = countCharacters(password, "!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?");
        int alphabetCount = countCharacters(password, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int digitCount = countCharacters(password, "0123456789");

       if(specialCount<3){
           return "Please include a minimum of 3 special characters";}
       else if (alphabetCount<3) {
            return "Please include a minimum of 3 alphabets";
       } else if (digitCount<3) {
            return "Please include atleast 3 numbers";
        }
        return "ok";
    }

    @Override
    public String checkNumber(String phoneNumber) {
        String regex = "\\d{10}";
        if (phoneNumber.matches(regex)) {
            if(userRepository.existsByPhoneNumber(phoneNumber)||employeeRepository.existsByPhoneNumber(phoneNumber)){
                return "Phone Number In Use";
            }

        }
        else{
            throw new RuntimeException("Wrong phone number format");
        }
        return null;
    }

    @Override
    public String checkEmail(String emailId) {
        String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(emailId.matches(regex)){
            if(userRepository.existsByEmailAddress(emailId)||employeeRepository.existsByEmailAddress(emailId)){
                return "Email already in use";
            }
        }
        else{
            throw new RuntimeException("Wrong email format");
        }
        return null;
    }

    @Override
    public String verifyNumber(String phoneNumber) {
        String base_url=ApiConfig.SMS_URL;
        String auth_key=ApiConfig.SMS_API_KEY;
        String otp_code=getOtp(6);
        Map<String,String> queryParams=new HashMap<>();
        queryParams.put("authorization",auth_key);
        queryParams.put("route","otp");
        queryParams.put("variables_values",otp_code);
        queryParams.put("numbers",phoneNumber);
        queryParams.put("flash", "0");

        UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(base_url);
        queryParams.forEach(builder::queryParam);
        URI uri=builder.build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<SmsDto> response = restTemplate.exchange(uri, HttpMethod.GET, entity, SmsDto.class);
        System.out.println(response);
        if(response.getStatusCode()==HttpStatus.OK){
            return otp_code;
        }
        else{
            throw new RuntimeException("Something went wrong");
        }
    }

    private String getOtp(int length) {
        StringBuilder otp=new StringBuilder(length);
        Random RANDOM=new Random();
        for (int i=0;i<length;i++){
            otp.append(RANDOM.nextInt(10));
        }
        return otp.toString();
    }

    public static int countCharacters(String input, String characters) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (characters.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
