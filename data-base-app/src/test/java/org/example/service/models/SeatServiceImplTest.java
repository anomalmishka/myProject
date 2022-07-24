package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.SeatDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Seat;
import org.example.service.models.SeatServiceImpl;
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
class SeatServiceImplTest {
    @Mock
    SeatDAO seatDAO;

    @InjectMocks
    SeatServiceImpl seatService;

    @Test
    public void whenCreate_thenReturnEntity() {
        Seat GIVEN = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Mockito.when(seatDAO.save(GIVEN)).thenReturn(ANSWER);
        Seat ACTUAL = seatService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(seatDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        Seat GIVEN = Seat.builder()
                .id(1L)
                .place(null)
                .type("Lowcost")
                .isOrdered(false)
                .build();
        assertThrows(ErrorInvalidData.class, () -> seatService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> ANSWER_LIST = List.of(ANSWER);
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(seatDAO.findAll()).thenReturn(ANSWER_LIST);
        List<Seat> ACTUAL_LIST = seatService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(seatDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(seatDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(seatService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Mockito.when(seatDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        Seat ACTUAL = seatService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(seatDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(seatDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> seatService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> ANSWER_LIST = List.of(ANSWER);
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(seatDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<Seat> ACTUAL_LIST = seatService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(seatDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(seatDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(seatService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Mockito.when(seatDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        Seat ACTUAL = seatService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(seatDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> seatService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> ANSWER_LIST = List.of(ANSWER);
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(seatDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(seatDAO).deleteAllById(GIVEN_LIST);
        List<Seat> ACTUAL_LIST = seatService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(seatDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(seatDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> seatService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        Seat GIVEN = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat ANSWER = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Seat EXPECTED = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        Mockito.when(seatDAO.save(GIVEN)).thenReturn(ANSWER);
        Seat ACTUAL = seatService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(seatDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        Seat GIVEN = Seat.builder()
                .id(1L)
                .place(null)
                .type("Lowcost")
                .isOrdered(false)
                .build();
        assertThrows(ErrorInvalidData.class, () -> seatService.update(GIVEN));
    }
}