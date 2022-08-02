package org.example.service.models.modif;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.example.service.models.api.FlightRouteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FlightRouteServiceImplModifTest {
    @Mock
    FlightRouteService flightRouteService;
    @Mock
    AirPlaneFlightRouteService airPlaneFlightRouteService;

    @InjectMocks
    FlightRouteServiceImplModif flightRouteServiceImplModif;

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
    public void whenCreate_thenReturnEntity() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
        Mockito.when(flightRouteService.create(GIVEN)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .create(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart(null)
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        Mockito.when(flightRouteService.create(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> flightRouteServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
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
        Mockito.when(flightRouteService.readAll()).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = flightRouteServiceImplModif.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .readAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
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
        Mockito.when(flightRouteService.readAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(flightRouteServiceImplModif.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
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
        Mockito.when(flightRouteService.readById(GIVEN_ID)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(flightRouteService.readById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> flightRouteServiceImplModif.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
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
        Mockito.when(flightRouteService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = flightRouteServiceImplModif.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .readAllByIds(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
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
        Mockito.when(flightRouteService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(flightRouteServiceImplModif.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
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
        Mockito.when(flightRouteService.deleteById(GIVEN_ID)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(flightRouteService.deleteById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> flightRouteServiceImplModif.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
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
        Mockito.when(flightRouteService.deleteAllByIds(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        List<FlightRoute> ACTUAL_LIST = flightRouteServiceImplModif.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .deleteAllByIds(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(flightRouteService).deleteAllByIds(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> flightRouteServiceImplModif.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
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
        Mockito.when(flightRouteService.update(GIVEN)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .update(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart(null)
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneFlightRouteList(airPlaneFlightRouteList)
                .build();
        assertThrows(ErrorInvalidData.class, () -> flightRouteServiceImplModif.update(GIVEN));
    }
}