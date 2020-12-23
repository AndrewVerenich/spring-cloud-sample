package com.cloud.sample.roomreservationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room-reservation")
public class RoomReservationController {
    //    private final RestTemplate restTemplate;
    private final RoomClient roomClient;

    public RoomReservationController(RoomClient roomClient) {
        this.roomClient = roomClient;
    }

    @GetMapping
    public List<RoomResrvation> getRoomReservation() {
        List<Room> rooms = roomClient.getAllRooms();
        List<RoomResrvation> roomResrvations = new ArrayList<>();
        rooms.forEach(room -> {
            RoomResrvation roomResrvation = new RoomResrvation();
            roomResrvation.setRoomNumber(room.getRoomNumber());
            roomResrvation.setRoomName(room.getName());
            roomResrvation.setRoomId(room.getId());
            roomResrvations.add(roomResrvation);
        });
        return roomResrvations;
    }

//    private List<Room> getAllRooms(){
//        ResponseEntity<List<Room>> roomResponse = restTemplate.exchange("http://ROOMSERVICE/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>(){});
//        return roomResponse.getBody();
//    }
}
