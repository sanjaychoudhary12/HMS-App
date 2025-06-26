package com.hms.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OTPUtil {

    private static final int OTP_LENGTH = 6;

    //Mehtod to  generate a OTP of (6 digits)
    public String generateOTP() {
        Random random = new Random();  // Create a Random object
        StringBuilder otp = new StringBuilder();
        for (int i=0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));  // Generate a  random digit between 0 and 9
        }
        return otp.toString();  // Return the generated OTP as a String
    }



}
