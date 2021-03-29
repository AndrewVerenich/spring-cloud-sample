package com.cloud.sample.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RestController
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("myRoute", r -> r
                        .after(ZonedDateTime.now())
                        .and()
                        .path("/rooms/**")
                        .filters(f -> f
                                .hystrix(h -> h.setFallbackUri("forward:/fallback"))
                                .addResponseHeader("Hello", "World")
                                .addRequestParameter("Param1", "Value1")
                        )
                        .uri("lb://ROOMSERVICE/"))
                .build();
    }

    @GetMapping(path = "/fallback")
    String fallbackMethod() {
        return "Fallback method";
    }
}
