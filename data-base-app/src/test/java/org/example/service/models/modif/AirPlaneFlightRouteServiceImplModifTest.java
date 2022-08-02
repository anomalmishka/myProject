package org.example.service.models.modif;

import org.assertj.core.api.Assertions;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirPlaneFlightRouteService;
import org.example.service.models.api.AirPlaneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AirPlaneFlightRouteServiceImplModifTest {

    @Mock
    AirPlaneService airPlaneService;

    @Mock
    AirPlaneFlightRouteService airPlaneFlightRouteService;
    @InjectMocks
    AirPlaneFlightRouteServiceImplModif airPlaneFlightRouteServiceImplModif;

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

    @Test
    public void whenCreate_thenReturnEntity() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.create(GIVEN)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .create(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.create(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> airPlaneFlightRouteServiceImplModif.create(GIVEN));
    }



    @Test
    public void whenReadAll_thenReturnEntityList() {
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneFlightRouteService.readAll()).thenReturn(ANSWER_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteServiceImplModif.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .readAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneFlightRouteService.readAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneFlightRouteServiceImplModif.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.readById(GIVEN_ID)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteServiceImplModif.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneFlightRouteService.readById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteServiceImplModif.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneFlightRouteService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteServiceImplModif.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .readAllByIds(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneFlightRouteService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneFlightRouteServiceImplModif.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.deleteById(GIVEN_ID)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteServiceImplModif.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneFlightRouteService.deleteById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteServiceImplModif.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneFlightRouteService.deleteAllByIds(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteServiceImplModif.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .deleteAllByIds(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(airPlaneFlightRouteService).deleteAllByIds(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteServiceImplModif.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        AirPlaneFlightRoute EXPECTED = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.update(GIVEN)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteService, Mockito.times(1))
                .update(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteService.update(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> airPlaneFlightRouteServiceImplModif.update(GIVEN));
    }
}