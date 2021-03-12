package com.cloud.sample.roomreservationservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.function.Function;

import static org.apache.commons.lang.RandomStringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomReservationController.class)
class RoomReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomClient roomClient;

    @MockBean
    List<String> testList;


    @Test
    void testController() throws Exception {

        when(roomClient.getAllRooms()).thenReturn(
                List.of(
                        new Room(11, "roomName", "123", "bedInfo"),
                        new Room(12, "roomName1", "124", "bedInfo1")
                )
        );

        mockMvc.perform(get("/room-reservation").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(request().asyncNotStarted())
                .andExpect(handler().methodName("getRoomReservation"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].roomId", Matchers.is(11)))
                .andExpect(jsonPath("$[1].roomId", Matchers.is(12)));
    }


    @Test
    void testMockito() {
        testList.add(randomNumeric(6));

        verify(testList, atLeastOnce()).add(any(String.class));

        when(testList.add(anyString())).thenReturn(true);
        assertThat(testList.add("g")).isTrue();
    }
}
