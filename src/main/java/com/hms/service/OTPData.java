package com.hms.service;

public class OTPData {


    // Helper class to store OTP data
        private final String otp;
        private final long expiryTime;

        public OTPData(String otp, long expiryTime) {
            this.otp = otp;
            this.expiryTime = expiryTime;
        }

        public String getOtp() {
            return otp;
        }

        public long getExpiryTime() {
            return expiryTime;
        }
    }

