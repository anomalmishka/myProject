package org.example.dao;

import org.example.dao.custom.seat.SeatCustomDAO;
import org.example.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@AutoConfigureTestDatabase
public class SeatCustomDAOTest {

    @Autowired
    SeatCustomDAO seatCustomDAO;

    private final Seat seat1 = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> EXPECTED_LIST = List.of(seat1);

    @Test
    public void whenSeatWhereAirPlaneId_thenReturnListEntity() {
        Long GIVEN = 1L;
        List<Seat> ACTUAL_LIST = seatCustomDAO.findSeatWhereAirPlaneId(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }
}
