package com.cloud.sample.guestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestRepository repository;

    public GuestController(GuestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Guest> getAllGuests(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Guest getGuest(@PathVariable("id") long id){
        return repository.findById(id).get();
    }
}
