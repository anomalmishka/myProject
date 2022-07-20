package org.example.service.filter;

import org.example.dao.custom.flightRoute.FlightRouteCustomDAOImpl;
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
    public void whereFindFlightRouteWhereDateStartAndDateEnd_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWherePriceStartAndPriceEnd_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWhereRouteSEAndDateSE_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWhereRouteSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWhereDateSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWhereRouteSEAndDateSEAndPriceSE_thenReturnEntityList() {
    }

    @Test
    public void whereFindFlightRouteWhereRouteSEOneWaypoint_thenReturnEntityList() {
    }
}