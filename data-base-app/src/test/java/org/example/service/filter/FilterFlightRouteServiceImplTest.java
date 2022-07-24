package org.example.service.filter;

import org.example.dao.custom.flightRoute.FlightRouteCustomDAOImpl;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FilterFlightRouteServiceImplTest {
    @Mock
    FlightRouteCustomDAOImpl flightRouteCustomDAO;

    @InjectMocks
    FilterFlightRouteServiceImpl filterFlightRouteService;

    @Test
    public void whereFindFlightRouteWhereRouteStartAndRouteEnd_thenReturnEntityList() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        List<FlightRoute> ANSWER_LIST = List.of(ANSWER);
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findFlightRouteWhereRouteStartAndRouteEnd(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findFlightRouteWhereRouteStartAndRouteEnd(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findFlightRouteWhereRouteStartAndRouteEnd(GIVEN);
    }
    @Test
    void whereFindFlightRouteWhereRouteStartAndRouteEnd_thenThrowErrorInvalidDataException() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart(null)
                .routeEnd("Moskva")
                .build();
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findFlightRouteWhereRouteStartAndRouteEnd(GIVEN));
    }

    @Test
    public void whereFindFlightRouteWhereDateStartAndDateEnd_thenReturnEntityList() {
        FilterObj GIVEN = FilterObj.builder()
                .dateStart(new Date(1656838800000L))
                .dateEnd(new Date(1656846000000L))
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        List<FlightRoute> ANSWER_LIST = List.of(ANSWER);
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findFlightRouteWhereDateStartAndDateEnd(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findFlightRouteWhereDateStartAndDateEnd(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findFlightRouteWhereDateStartAndDateEnd(GIVEN);
    }

    @Test
    void whereFindFlightRouteWhereDateStartAndDateEnd_thenThrowErrorInvalidDataException() {
        FilterObj GIVEN = FilterObj.builder()
                .dateStart(null)
                .dateEnd(new Date(1656846000000L))
                .build();
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findFlightRouteWhereDateStartAndDateEnd(GIVEN));
    }


    @Test
    public void whereFindFlightRouteWhereRouteSEOneWaypoint_thenReturnEntityList() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Moskva")
                .routeEnd("London")
                .build();
        FlightRoute ANSWER_1 = FlightRoute.builder()
                .id(1L)
                .routeStart("Moskva")
                .routeEnd("Minsk")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        FlightRoute ANSWER_2 = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("London")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        FlightRoute EXPECTED_1 = FlightRoute.builder()
                .id(1L)
                .routeStart("Moskva")
                .routeEnd("Minsk")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        FlightRoute EXPECTED_2 = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("London")
                .flightDateStart(new Date(1656838800000L))
                .flightDateEnd(new Date(1656846000000L))
                .build();
        List<FlightRoute> ANSWER_LIST = List.of(ANSWER_1, ANSWER_2);
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED_1, EXPECTED_2);
        Mockito.when(flightRouteCustomDAO.findFlightRouteWhereRouteSEOneWaypoint(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findFlightRouteWhereRouteSEOneWaypoint(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findFlightRouteWhereRouteSEOneWaypoint(GIVEN);
    }

    @Test
    void whereFindFlightRouteWhereRouteSEOneWaypoint_thenThrowErrorInvalidDataException() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart(null)
                .routeEnd("Moskva")
                .build();
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findFlightRouteWhereRouteStartAndRouteEnd(GIVEN));
    }
}