package org.example.dao;

import lombok.SneakyThrows;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.model.*;
import org.example.dto.filter.FilterObj;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@AutoConfigureTestDatabase
public class FlightRouteCustomDAOTest {

    @Autowired
    FlightRouteCustomDAO flightRouteCustomDAO;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }

    private final Seat seat1 = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final Seat seat2 = Seat.builder()
            .id(2L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final Seat seat3 = Seat.builder()
            .id(3L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList1 = List.of(seat1);
    private final List<Seat> seatList2 = List.of(seat2);
    private final List<Seat> seatList3 = List.of(seat3);
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
    private final AirPlane airPlane2 = AirPlane.builder()
            .id(2L)
            .type("Boing747")
            .status("Ready to fly")
            .numberSeatLowcost(5)
            .numberSeatBuisness(1)
            .isActive(true)
            .airCompany(airCompany1)
            .seatList(seatList2)
            .build();
    private final AirPlane airPlane3 = AirPlane.builder()
            .id(3L)
            .type("Boing747")
            .status("Ready to fly")
            .numberSeatLowcost(5)
            .numberSeatBuisness(1)
            .isActive(true)
            .airCompany(airCompany1)
            .seatList(seatList3)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute1 = AirPlaneFlightRoute.builder()
            .id(1L)
            .airPlane(airPlane1)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute2 = AirPlaneFlightRoute.builder()
            .id(2L)
            .airPlane(airPlane2)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute3 = AirPlaneFlightRoute.builder()
            .id(3L)
            .airPlane(airPlane3)
            .build();
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList1 = List.of(airPlaneFlightRoute1);
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList2 = List.of(airPlaneFlightRoute2);
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList3 = List.of(airPlaneFlightRoute3);
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
    private final FlightRoute EXPECTED2 = FlightRoute.builder()
            .id(2L)
            .routeStart("Minsk")
            .routeEnd("London")
            .distance(1000)
            .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 14:00:00")))
            .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 15:00:00")))
            .price(300)
            .duration(120)
            .isActive(true)
            .airPlaneFlightRouteList(airPlaneFlightRouteList2)
            .build();

    private final FlightRoute EXPECTED3 = FlightRoute.builder()
            .id(3L)
            .routeStart("London")
            .routeEnd("Moskva")
            .distance(1000)
            .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 15:00:00")))
            .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 16:00:00")))
            .price(400)
            .duration(180)
            .isActive(true)
            .airPlaneFlightRouteList(airPlaneFlightRouteList3)
            .build();

    @Test
    public void whenFindWhereRouteStart_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1, EXPECTED2);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteEnd_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateEnd(new Timestamp(parseStringToLong("2022-09-03 16:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereDateStart_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .dateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1,EXPECTED2,EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWherePrice_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .price(200)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereAirCompanyName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .airCompanyName("Belavia")
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1, EXPECTED2, EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }


    @Test
    public void whenFindWhereDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .duration(60)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereDateEnd_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .dateEnd(new Timestamp(parseStringToLong("2022-09-03 16:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1,EXPECTED2,EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStartRouteEnd_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStartRouteEndDateStart_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStartRouteEndDateStartDateEnd_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
                .dateEnd(new Timestamp(parseStringToLong("2022-09-03 16:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStartRouteEndDateEnd_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateEnd(new Timestamp(parseStringToLong("2022-09-03 16:00:00")))
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStartRouteTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .transfer("London")
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED1, EXPECTED2, EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.filter(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }
}
