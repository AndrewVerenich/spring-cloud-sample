package com.cloud.sample.roomreservationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JsonTest
class RoomReservationSerializationTest {

    @Autowired
    private JacksonTester<Room> jacksonTester;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldSerializeObject() throws IOException {
        assertNotNull(objectMapper);
        Room room = new Room();
        room.setId(12);
        room.setName("VIP room");
        room.setRoomNumber("113a");

        JsonContent<Room> result = jacksonTester.write(room);
        assertThat(result).hasJsonPathStringValue("$.name");
        assertThat(result).extractingJsonPathStringValue("name").isEqualTo("VIP room");
        assertThat(result).doesNotHaveEmptyJsonPathValue("id");
    }

}