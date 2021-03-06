package com.cloud.sample.reservationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReservationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApp.class, args);
    }

}
