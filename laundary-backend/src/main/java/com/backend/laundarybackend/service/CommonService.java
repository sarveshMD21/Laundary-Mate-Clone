package com.backend.laundarybackend.service;

import java.io.IOException;

public interface CommonService {

    String checkPasswordOfUser(String password) throws IOException;

    String checkNumber(String phoneNumber);

    String checkEmail(String emailId);

    String verifyNumber(String phoneNumber);
}
