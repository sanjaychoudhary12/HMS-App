package com.hms.service;

import com.hms.util.OTPUtil;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OTPService {

    @Autowired
    private OTPUtil otpUtil;

    // Temporary in-memory storage (for production, use Redis/DB)
    private static final Map<String, OTPData> otpStorage = new HashMap<>();
    private static final long OTP_EXPIRY_TIME = 5 * 60 * 1000; // 5 minutes in ms

    // Twilio credentials
    private static final String ACCOUNT_SID = "your_account_sid";
    private static final String AUTH_TOKEN = "your_auth_token";
    private static final String FROM_PHONE = "+your_twilio_phone_number";

    // Initialize Twilio
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    // Generate OTP and send SMS
    public String generateAndSendOTP(String mobileNumber) {
        String otp = otpUtil.generateOTP(); // Generate 6-digit OTP

        long expiryTime = System.currentTimeMillis() + OTP_EXPIRY_TIME;
        otpStorage.put(mobileNumber, new OTPData(otp,expiryTime));

        // Send SMS
        sendOTPviaSMS(mobileNumber, otp);

        return otp; // Optional: avoid returning in real app
    }

    // Send OTP via Twilio SMS
    private void sendOTPviaSMS(String mobileNumber, String otp) {
        Message.creator(
                new com.twilio.type.PhoneNumber(mobileNumber),
                new com.twilio.type.PhoneNumber(FROM_PHONE),
                "Your OTP code is: " + otp
        ).create();
    }

    // Validate the OTP
    public boolean validateOTP(String mobileNumber, String otp) {
        OTPData storedData = otpStorage.get(mobileNumber);

        if (storedData == null) return false;

        // Check expiry
        if (System.currentTimeMillis() > storedData.getExpiryTime()) {
            otpStorage.remove(mobileNumber); // Remove expired OTP
            return false;
        }

        // Validate OTP
        if (storedData.getOtp().equals(otp)) {
            otpStorage.remove(mobileNumber); // OTP valid, remove it
            return true;
        }

        return false;
    }


}
