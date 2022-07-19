package org.example.service.filter;

import org.example.dao.custom.airPlane.AirPlaneCustomDAO;
import org.example.dao.custom.airPlane.AirPlaneCustomDAOImpl;
import org.example.model.entity.AirPlane;
import org.example.model.filter.FilterAirPlaneObject;
import org.example.service.filter.api.FilterAirPlaneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FilterAirPlaneServiceImplTest {
    @Mock
    AirPlaneCustomDAOImpl airPlaneCustomDAO;

    @InjectMocks
    FilterAirPlaneServiceImpl filterAirPlaneService;

    @Test
    void whereFindAirPlaneWhereRouteStartAndRouteEnd_thenReturnEntityList() {
        FilterAirPlaneObject GIVEN = FilterAirPlaneObject.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("747")
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .ticketPrice(200)
                .numberPassanger(100)
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("747")
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .ticketPrice(200)
                .numberPassanger(100)
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneCustomDAO.findAirPlaneWhereRouteStartAndRouteEnd(GIVEN)).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = filterAirPlaneService.findAirPlaneWhereRouteStartAndRouteEnd(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneCustomDAO, Mockito.times(1))
                .findAirPlaneWhereRouteStartAndRouteEnd(GIVEN);
    }

    @Test
    void whereFindAirPlaneWhereDateStartAndDateEnd_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWherePriceStartAndPriceEnd_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWhereRouteSEAndDateSE_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWhereRouteSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWhereDateSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWhereRouteSEAndDateSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    void whereFindAirPlaneWhereRouteSEOneWaypoint_thenReturnEntityList() {
    }
}