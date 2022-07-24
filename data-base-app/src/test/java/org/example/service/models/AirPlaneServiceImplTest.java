package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.AirPlaneDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirPlane;
import org.example.service.models.AirPlaneServiceImpl;
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
class AirPlaneServiceImplTest {
    @Mock
    AirPlaneDAO airPlaneDAO;

    @InjectMocks
    AirPlaneServiceImpl airPlaneService;

    @Test
    public void whenCreate_thenReturnEntity() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        Mockito.when(airPlaneDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type(null)
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        assertThrows(ErrorInvalidData.class, () -> airPlaneService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneDAO.findAll()).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .findAll();
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneService.readAll()).size().isEqualTo(EXPECTED);
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        Mockito.when(airPlaneDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        AirPlane ACTUAL = airPlaneService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airPlaneDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> airPlaneService.readById(GIVEN_ID));
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airPlaneDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airPlaneService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        Mockito.when(airPlaneDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        AirPlane ACTUAL = airPlaneService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> airPlaneService.deleteById(GIVEN_ID));
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
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> ANSWER_LIST = List.of(ANSWER);
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airPlaneDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(airPlaneDAO).deleteAllById(GIVEN_LIST);
        List<AirPlane> ACTUAL_LIST = airPlaneService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(airPlaneDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> airPlaneService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        Mockito.when(airPlaneDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airPlaneDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type(null)
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        assertThrows(ErrorInvalidData.class, () -> airPlaneService.update(GIVEN));
    }
}