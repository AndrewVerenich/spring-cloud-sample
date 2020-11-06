package com.cloud.sample.roomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RoomServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(RoomServiceApp.class, args);
    }

}
