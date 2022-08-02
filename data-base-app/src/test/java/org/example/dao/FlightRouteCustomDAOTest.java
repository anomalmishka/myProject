package org.example.dao;

import lombok.SneakyThrows;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.model.entity.*;
import org.example.model.filter.FilterObj;
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
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRouteStart_thenReturnListEntity() {
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
        Seat seat1 = Seat.builder()
                .id(1L)
                .type("Lowcost")
                .place("1A")
                .isOrdered(true)
                .build();
        List<Seat> seatList1 = List.of(seat1);
        AirCompany airCompany1 = AirCompany.builder()
                .id(1L)
                .nameCompany("Belavia")
                .countryLocation("Minsk")
                .build();
        AirPlane airPlane1 = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .airCompany(airCompany1)
                .seatList(seatList1)
                .build();
        AirPlaneFlightRoute airPlaneFlightRoute4 = AirPlaneFlightRoute.builder()
                .id(2L)
                .airPlane(airPlane1)
                .build();
        List<AirPlaneFlightRoute> airPlaneFlightRouteList4 = List.of(airPlaneFlightRoute4);
        AirPlaneFlightRoute airPlaneFlightRoute1 = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane1)
                .build();
        List<AirPlaneFlightRoute> airPlaneFlightRouteList1 = List.of(airPlaneFlightRoute1);
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(new Timestamp(parseStringToLong("2022-07-03 12:00:00")))
                .flightDateEnd(new Timestamp(parseStringToLong("2022-07-03 13:00:00")))
                .price(200)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList1)
                .build();
        FlightRoute EXPECTED3 = FlightRoute.builder()
                .id(2L)
                .routeStart("Minsk")
                .routeEnd("London")
                .distance(2000)
                .flightDateStart(new Timestamp(parseStringToLong("2022-07-03 20:00:00")))
                .flightDateEnd(new Timestamp(parseStringToLong("2022-07-03 23:00:00")))
                .price(600)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList4)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED, EXPECTED3);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteStart(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereRoute_thenReturnListEntity() {
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
        List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);
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
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoute(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWhereDate_thenReturnListEntity() {
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
        List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);
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
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDate(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

    @Test
    public void whenFindWherePrice_thenReturnListEntity() {
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
        List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);
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
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWherePrice(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
    }

//    @Test
//    public void whenFindWhereDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDateName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDateName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDateName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWherePriceName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWherePriceName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWherePriceName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDate_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDate(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDate(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePrice_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePrice(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePrice(GIVEN);
//    }
//
//
//    @Test
//    public void whenFindWhereRouteDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDatePrice_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDatePrice(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDatePrice(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDateDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDateDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDateDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWherePriceDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWherePriceDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWherePriceDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDateName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDateName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDateName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePriceName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePriceName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePriceName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDatePriceName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDatePriceName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDatePriceName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDateDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDateDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDateDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWherePriceDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWherePriceDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWherePriceDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDateTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDateTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDateTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePriceTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePriceTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePriceTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDurationTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDurationTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDurationTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePrice_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePrice(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePrice(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDateDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDateDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDateDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePriceDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePriceDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePriceDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDatePriceDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDatePriceDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDatePriceDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDateDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDateDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDateDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePriceDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePriceDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePriceDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereDatePriceDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereDatePriceDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereDatePriceDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDateDurationTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDateDurationTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDateDurationTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRoutePriceDurationTransfer_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRoutePriceDurationTransfer(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRoutePriceDurationTransfer(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceDuration_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceDuration(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceDuration(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceDurationName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceDurationName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceDurationName(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceDurationTranfser_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfser(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceDurationTranfser(GIVEN);
//    }
//
//    @Test
//    public void whenFindWhereRouteDatePriceDurationTranfserName_thenReturnListEntity() {
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
//        List<FlightRoute> ACTUAL_LIST = flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfserName(GIVEN);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
//                .findWhereRouteDatePriceDurationTranfserName(GIVEN);
//    }
}
