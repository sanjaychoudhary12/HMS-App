package com.hms.service;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

       // private final TwilioConfig twilioConfig;

        public void sendSms(String to, String otp) {
           Message message =  Message.creator(
                  new com.twilio.type.PhoneNumber(to),
                    new com.twilio.type.PhoneNumber("mobile number provided by twilio"),
                    otp
            ).create();
        }
    }


