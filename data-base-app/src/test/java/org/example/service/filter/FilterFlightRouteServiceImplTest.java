package org.example.service.filter;

import lombok.SneakyThrows;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.exception.ErrorInvalidData;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    private final Seat seat = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList = List.of(seat);
    private final AirCompany airCompany = AirCompany.builder()
            .id(1L)
            .nameCompany("Aeroflot")
            .countryLocation("Russia")
            .build();
    private final AirPlane airPlane = AirPlane.builder()
            .id(1L)
            .type("747")
            .status("Landing")
            .numberSeatLowcost(5)
            .numberSeatBuisness(1)
            .isActive(true)
            .airCompany(airCompany)
            .seatList(seatList)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute = AirPlaneFlightRoute.builder()
            .id(1L)
            .airPlane(airPlane)
            .build();
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);

//    @Test
//    public void whenFindWhereName_thenReturnListEntity() {
//        FilterObj GIVEN = FilterObj.builder()
//                .routeStart("Minsk")
//                .routeEnd("Moskva")
//                .dateStart(flightDateStart)
//                .dateEnd(flightDateEnd)
//                .priceStart(0)
//                .priceEnd(300)
//                .airCompanyName("Belavia")
//                .transfers("London")
//                .durationStart(0)
//                .durationEnd(120)
//                .build();
//        FlightRoute ANSWER = FlightRoute.builder()
//                .id(1L)
//                .routeStart("Minsk")
//                .routeEnd("Moskva")
//                .distance(1000)
//                .flightDateStart(flightDateStart)
//                .flightDateEnd(flightDateEnd)
//                .isActive(true)
//                .airPlaneFlightRouteList(airPlaneFlightRouteList)
//                .build();
//        List<FlightRoute> ANSWER_LIST = List.of(ANSWER);
//        FlightRoute EXPECTED = FlightRoute.builder()
//                .id(1L)
//                .routeStart("Minsk")
//                .routeEnd("Moskva")
//                .distance(1000)
//                .flightDateStart(flightDateStart)
//                .flightDateEnd(flightDateEnd)
//                .isActive(true)
//                .airPlaneFlightRouteList(airPlaneFlightRouteList)
//                .build();
//        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
//        Mockito.when(flightRouteCustomDAO.findWhereName(GIVEN)).thenReturn(ANSWER_LIST);
//        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereName_thenThrowErrorInvalidDataException() {
//        FilterObj GIVEN = FilterObj.builder()
//                .routeStart(null)
//                .routeEnd(null)
//                .dateStart(null)
//                .dateEnd(null)
//                .priceStart(null)
//                .priceEnd(null)
//                .airCompanyName(null)
//                .transfers(null)
//                .durationStart(null)
//                .durationEnd(null)
//                .build();
//        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereName(GIVEN));
//    }
}