package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.AirPlaneFlightRouteDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AirPlaneFlightRouteServiceImplTest {
    @Mock
    AirPlaneFlightRouteDAO airPlaneFlightRouteDAO;

    @InjectMocks
    AirPlaneFlightRouteServiceImpl airPlaneFlightRouteService;

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
        Mockito.when(airPlaneFlightRouteDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        Mockito.when(airPlaneFlightRouteDAO.save(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> airPlaneFlightRouteService.create(GIVEN));
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
        Mockito.when(airPlaneFlightRouteDAO.findAll()).thenReturn(ANSWER_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        AirPlaneFlightRoute ANSWER = AirPlaneFlightRoute.builder()
                .id(1L)
                .airPlane(airPlane)
                .build();
        List<AirPlaneFlightRoute> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneFlightRouteDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneFlightRouteService.readAll()).size().isEqualTo(EXPECTED);
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
        Mockito.when(airPlaneFlightRouteDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneFlightRouteDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteService.readById(GIVEN_ID));
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
        Mockito.when(airPlaneFlightRouteDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
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
        Mockito.when(airPlaneFlightRouteDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneFlightRouteService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
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
        Mockito.when(airPlaneFlightRouteDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteService.deleteById(GIVEN_ID));
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
        Mockito.when(airPlaneFlightRouteDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(airPlaneFlightRouteDAO).deleteAllById(GIVEN_LIST);
        List<AirPlaneFlightRoute> ACTUAL_LIST = airPlaneFlightRouteService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(airPlaneFlightRouteDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneFlightRouteService.deleteAllByIds(GIVEN_LIST));
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
        Mockito.when(airPlaneFlightRouteDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlaneFlightRoute ACTUAL = airPlaneFlightRouteService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneFlightRouteDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        AirPlaneFlightRoute GIVEN = AirPlaneFlightRoute.builder()
                .id(null)
                .airPlane(airPlane)
                .build();
        assertThrows(ErrorInvalidData.class, () -> airPlaneFlightRouteService.update(GIVEN));
    }
}