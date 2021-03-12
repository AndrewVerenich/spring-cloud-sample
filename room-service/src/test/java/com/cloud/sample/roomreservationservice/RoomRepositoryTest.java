package com.cloud.sample.roomreservationservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class RoomRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void testJpa() {
        assertEquals(28, ((Collection<?>) roomRepository.findAll()).size());
        assertNotNull(entityManager);
    }

}
