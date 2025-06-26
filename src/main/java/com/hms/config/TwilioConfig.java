package com.hms.config;

import com.twilio.Twilio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TwilioConfig {

    @Bean
    public void init() {
        Twilio.init("twilio auth username", "twilio auth token");
    }
}
