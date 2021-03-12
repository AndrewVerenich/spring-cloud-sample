package com.cloud.sample.roomreservationservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class RoomReservationAppContextTest {

    @Autowired
    RoomReservationController controller;

    @Test
    void contextTest() {
        assertThat(controller).isNotNull();
    }
}