package org.example.service.filter;

import lombok.SneakyThrows;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.model.*;
import org.example.dto.filter.FilterObj;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FilterFlightRouteServiceImplTest {
    @Mock
    FlightRouteCustomDAO flightRouteCustomDAO;

    @InjectMocks
    FilterFlightRouteServiceImpl filterFlightRouteService;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }

    private final Timestamp flightDateStart = new Timestamp(parseStringToLong("2022-07-03 12:00:00"));
    private final Timestamp flightDateEnd = new Timestamp(parseStringToLong("2022-07-03 14:00:00"));


    private final Seat seat1 = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList1 = List.of(seat1);
    private final AirCompany airCompany1 = AirCompany.builder()
            .id(1L)
            .nameCompany("Belavia")
            .countryLocation("Minsk")
            .build();
    private final AirPlane airPlane1 = AirPlane.builder()
            .id(1L)
            .type("Boing747")
            .status("Ready to fly")
            .numberSeatLowcost(5)
            .numberSeatBuisness(1)
            .isActive(true)
            .airCompany(airCompany1)
            .seatList(seatList1)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute1 = AirPlaneFlightRoute.builder()
            .id(1L)
            .airPlane(airPlane1)
            .build();
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList1 = List.of(airPlaneFlightRoute1);
    private final FlightRoute EXPECTED1 = FlightRoute.builder()
            .id(1L)
            .routeStart("Minsk")
            .routeEnd("Moskva")
            .distance(1000)
            .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
            .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 13:00:00")))
            .price(200)
            .duration(60)
            .isActive(true)
            .airPlaneFlightRouteList(airPlaneFlightRouteList1)
            .build();
    @Test
    public void whenFindWhereName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .price(200)
                .airCompanyName("Belavia")
                .transfer("London")
                .duration(60)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList1)
                .build();
        List<FlightRoute> ANSWER_LIST = List.of(ANSWER);
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList1)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.filter(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .filter(GIVEN);
    }
}