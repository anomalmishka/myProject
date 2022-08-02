package org.example.service.filter;

import lombok.SneakyThrows;
import org.example.dao.custom.flightRoute.FlightRouteCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.model.filter.FilterObj;
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

    @Test
    public void whenFindWhereName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereName(GIVEN);
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


    @Test
    public void whenFindWhereRouteStart_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteStart(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteStart(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteStart(GIVEN);
    }

    @Test
    public void whenFindWhereRouteStart_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteStart(GIVEN));
    }


    @Test
    public void whenFindWhereRoute_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoute(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoute(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoute(GIVEN);
    }

    @Test
    public void whenFindWhereRoute_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoute(GIVEN));
    }

    @Test
    public void whenFindWhereDate_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDate(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDate(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDate(GIVEN);
    }

    @Test
    public void whenFindWhereDate_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDate(GIVEN));
    }

    @Test
    public void whenFindWherePrice_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWherePrice(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWherePrice(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWherePrice(GIVEN);
    }

    @Test
    public void whenFindWherePrice_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWherePrice(GIVEN));
    }

    @Test
    public void whenFindWhereDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDuration(GIVEN);
    }

    @Test
    public void whenFindWhereDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDuration(GIVEN));
    }

    @Test
    public void whenFindWhereRouteName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteName(GIVEN));
    }

    @Test
    public void whenFindWhereDateName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDateName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDateName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDateName(GIVEN);
    }

    @Test
    public void whenFindWhereDateName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDateName(GIVEN));
    }

    @Test
    public void whenFindWherePriceName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWherePriceName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWherePriceName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWherePriceName(GIVEN);
    }

    @Test
    public void whenFindWherePriceName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWherePriceName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRouteTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDate_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDate(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDate(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDate(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDate_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDate(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePrice_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePrice(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePrice(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePrice(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePrice_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePrice(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDuration(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDuration(GIVEN));
    }

    @Test
    public void whenFindWhereDatePrice_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDatePrice(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDatePrice(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDatePrice(GIVEN);
    }

    @Test
    public void whenFindWhereDatePrice_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDatePrice(GIVEN));
    }

    @Test
    public void whenFindWhereDateDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDateDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDateDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDateDuration(GIVEN);
    }

    @Test
    public void whenFindWhereDateDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDateDuration(GIVEN));
    }

    @Test
    public void whenFindWherePriceDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWherePriceDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWherePriceDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWherePriceDuration(GIVEN);
    }

    @Test
    public void whenFindWherePriceDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWherePriceDuration(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDateName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDateName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDateName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDateName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDateName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDateName(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePriceName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePriceName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePriceName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePriceName(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePriceName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePriceName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereDatePriceName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDatePriceName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDatePriceName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDatePriceName(GIVEN);
    }

    @Test
    public void whenFindWhereDatePriceName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDatePriceName(GIVEN));
    }

    @Test
    public void whenFindWhereDateDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDateDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDateDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDateDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereDateDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDateDurationName(GIVEN));
    }

    @Test
    public void whenFindWherePriceDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWherePriceDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWherePriceDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWherePriceDurationName(GIVEN);
    }

    @Test
    public void whenFindWherePriceDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWherePriceDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDateTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDateTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDateTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDateTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDateTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDateTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePriceTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePriceTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePriceTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePriceTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePriceTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePriceTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDurationTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDurationTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDurationTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDurationTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDurationTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDurationTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePrice_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePrice(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePrice(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePrice(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePrice_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePrice(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDateDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDateDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDateDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDateDuration(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDateDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDateDuration(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePriceDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePriceDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePriceDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePriceDuration(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePriceDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePriceDuration(GIVEN));
    }

    @Test
    public void whenFindWhereDatePriceDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDatePriceDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDatePriceDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDatePriceDuration(GIVEN);
    }

    @Test
    public void whenFindWhereDatePriceDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDatePriceDuration(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDateDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDateDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDateDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDateDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDateDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDateDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePriceDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePriceDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePriceDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePriceDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePriceDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePriceDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereDatePriceDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereDatePriceDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereDatePriceDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereDatePriceDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereDatePriceDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereDatePriceDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDateDurationTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDateDurationTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDateDurationTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDateDurationTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDateDurationTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDateDurationTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRoutePriceDurationTransfer_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRoutePriceDurationTransfer(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRoutePriceDurationTransfer(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRoutePriceDurationTransfer(GIVEN);
    }

    @Test
    public void whenFindWhereRoutePriceDurationTransfer_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRoutePriceDurationTransfer(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceDuration_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceDuration(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceDuration(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceDuration(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceDuration_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceDuration(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceDurationName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceDurationName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceDurationName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceDurationName(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationTranfser_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfser(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceDurationTranfser(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceDurationTranfser(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationTranfser_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceDurationTranfser(GIVEN));
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationTranfserName_thenReturnListEntity() {
        FilterObj GIVEN = FilterObj.builder()
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .dateStart(flightDateStart)
                .dateEnd(flightDateEnd)
                .priceStart(0)
                .priceEnd(300)
                .airCompanyName("Belavia")
                .transfers("London")
                .durationStart(0)
                .durationEnd(120)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        List<FlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(flightRouteCustomDAO.findWhereRouteDatePriceDurationTranfserName(GIVEN)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = filterFlightRouteService.findWhereRouteDatePriceDurationTranfserName(GIVEN);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteCustomDAO, Mockito.times(1))
                .findWhereRouteDatePriceDurationTranfserName(GIVEN);
    }

    @Test
    public void whenFindWhereRouteDatePriceDurationTranfserName_thenThrowErrorInvalidDataException() {
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
        assertThrows(ErrorInvalidData.class, () -> filterFlightRouteService.findWhereRouteDatePriceDurationTranfserName(GIVEN));
    }
}