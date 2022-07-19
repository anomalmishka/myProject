package org.example.service.dao;

import org.example.dao.custom.airPlane.AirPlaneCustomDAO;
import org.example.model.entity.AirPlane;
import org.example.model.filter.FilterAirPlaneObject;
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
public class AirPlaneCustomDAOTest {

    @Autowired
    private AirPlaneCustomDAO airPlaneCustomDAO;

    @Test
    void whenFindAirPlaneWhereRouteStartAndRouteEnd_thenEntityFindWithFilterAirPlaneObject() {
        FilterAirPlaneObject GIVEN = FilterAirPlaneObject.builder()
                .build();
        AirPlane EXPECTED = AirPlane.builder().build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        List<AirPlane> ACTUAL_LIST = airPlaneCustomDAO.findAirPlaneWhereRouteStartAndRouteEnd(GIVEN);
        Assertions.assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

}
