package org.example.service.models.modif;

import org.assertj.core.api.Assertions;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirCompanyService;
import org.example.service.models.api.AirPlaneService;
import org.example.service.models.api.SeatService;
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
class AirPlaneServiceImplModifTest {
    @Mock
    AirPlaneService airPlaneService;
    @Mock
    AirCompanyService airCompanyService;
    @Mock
    SeatService seatService;
    @InjectMocks
    AirPlaneServiceImplModif airPlaneServiceImplModif;

    private final AirCompany airCompany = AirCompany.builder()
            .id(1L)
            .nameCompany("Aeroflot")
            .countryLocation("Russia")
            .build();
    private final Seat seat = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList = List.of(seat);

    @Test
    public void whenCreate_thenReturnEntity() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        Mockito.when(airPlaneService.create(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .create(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type(null)
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        assertThrows(ErrorInvalidData.class, () -> airPlaneServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneService.readAll()).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneServiceImplModif.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .readAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneService.readAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneServiceImplModif.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        Mockito.when(airPlaneService.readById(GIVEN_ID)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneService.readById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneServiceImplModif.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneServiceImplModif.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .readAllByIds(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneServiceImplModif.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        Mockito.when(airPlaneService.deleteById(GIVEN_ID)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneService.deleteById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneServiceImplModif.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneService.deleteAllByIds(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneServiceImplModif.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .deleteAllByIds(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(airPlaneService).deleteAllByIds(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneServiceImplModif.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        Mockito.when(airPlaneService.update(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneService, Mockito.times(1))
                .update(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type(null)
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .isActive(true)
                .seatList(seatList)
                .airCompany(airCompany)
                .build();
        assertThrows(ErrorInvalidData.class, () -> airPlaneServiceImplModif.update(GIVEN));
    }
}