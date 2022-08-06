package org.example.serviceWithDAO;

import lombok.SneakyThrows;
import org.example.exception.ErrorInvalidData;
import org.example.model.*;
import org.example.dto.filter.FilterObj;
import org.example.service.filter.api.FilterFlightRouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@AutoConfigureTestDatabase
public class FlightRouteServiceDAOTest {

    @Autowired
    FilterFlightRouteService filterFlightRouteService;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }
    @Test
    public void whenFindWhereName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(new Timestamp(parseStringToLong("2022-07-03 12:00:00")))
                .dateEnd(new Timestamp(parseStringToLong("2022-07-03 13:00:00")))
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        Seat seat = Seat.builder()
                .id(1L)
                .type("Lowcost")
                .place("1A")
                .isOrdered(true)
                .build();
        List<Seat> seatList = List.of(seat);
        AirCompany airCompany = AirCompany.builder()
                .id(1L)
                .nameCompany("Belavia")
                .countryLocation("Minsk")
                .build();
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .airCompany(airCompany)
                .seatList(seatList)
                .build();
        AirPlaneFlightRoute airPlaneFlightRoute = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute airPlaneFlightRoute2 = AirPlaneFlightRoute.builder()
                .id(2L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute airPlaneFlightRoute3 = AirPlaneFlightRoute.builder()
                .id(3L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);
        List<AirPlaneFlightRoute> airPlaneFlightRouteList2 = List.of(airPlaneFlightRoute2);
        List<AirPlaneFlightRoute> airPlaneFlightRouteList3 = List.of(airPlaneFlightRoute3);
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(new Timestamp(parseStringToLong("2022-07-03 12:00:00")))
                .flightDateEnd(new Timestamp(parseStringToLong("2022-07-03 13:00:00")))
                .price(200)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        FlightRoute EXPECTED2 = FlightRoute.builder()
                .id(2L)
                .routeStart("Minsk")
                .routeEnd("London")
                .distance(2000)
                .flightDateStart(new Timestamp(parseStringToLong("2022-07-03 20:00:00")))
                .flightDateEnd(new Timestamp(parseStringToLong("2022-07-03 23:00:00")))
                .price(600)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList2)
                .build();
        FlightRoute EXPECTED3 = FlightRoute.builder()
                .id(3L)
                .routeStart("London")
                .routeEnd("Moskva")
                .distance(3000)
                .flightDateStart(new Timestamp(parseStringToLong("2022-07-05 12:00:00")))
                .flightDateEnd(new Timestamp(parseStringToLong("2022-07-05 17:00:00")))
                .price(800)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList3)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED,EXPECTED2,EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereName_thenThrowErrorInvalidDataException() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart(null)
                .routeEnd(null)
                .dateStart(null)
                .dateEnd(null)
                .priceStart(null)
                .priceEnd(null)
                .airCompanyName(null)
                .transfers(null)
                .durationStart(null)
                .durationEnd(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereName(GIVEN));
    }
}
