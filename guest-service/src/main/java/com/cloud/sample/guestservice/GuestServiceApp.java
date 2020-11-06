package com.cloud.sample.guestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GuestServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(GuestServiceApp.class);
    }
}
