package com.suji.followup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailFollowUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailFollowUpApplication.class, args);
    }
}
