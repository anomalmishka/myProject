package org.example.dao;

import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class FlightRouteCustomDAOTest {

    @Autowired
    private FlightRouteCustomDAO flightRouteCustomDAO;

    @Test
    void whenFindFlightRouteWhereRouteStartAndRouteEnd_thenEntityFindWithFilterAirPlaneObject() {
        FilterObj GIVEN = FilterObj.builder()
                .build();
        FlightRoute EXPECTED = FlightRoute.builder().build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findFlightRouteWhereRouteStartAndRouteEnd(GIVEN);
        Assertions.assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

}
