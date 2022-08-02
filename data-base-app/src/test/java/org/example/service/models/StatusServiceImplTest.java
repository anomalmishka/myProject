package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.StatusDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.Status;
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
class StatusServiceImplTest {
    @Mock
    StatusDAO statusDAO;

    @InjectMocks
    StatusServiceImpl statusService;

    @Test
    public void whenCreate_thenReturnEntity() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Mockito.when(statusDAO.save(GIVEN)).thenReturn(ANSWER);
        Status ACTUAL = statusService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> statusService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> ANSWER_LIST = List.of(ANSWER);
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(statusDAO.findAll()).thenReturn(ANSWER_LIST);
        List<Status> ACTUAL_LIST = statusService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(statusDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(statusDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(statusService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Mockito.when(statusDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        Status ACTUAL = statusService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(statusDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> statusService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> ANSWER_LIST = List.of(ANSWER);
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(statusDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<Status> ACTUAL_LIST = statusService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(statusDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(statusDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(statusService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Mockito.when(statusDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        Status ACTUAL = statusService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> statusService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> ANSWER_LIST = List.of(ANSWER);
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        List<Status> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(statusDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(statusDAO).deleteAllById(GIVEN_LIST);
        List<Status> ACTUAL_LIST = statusService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(statusDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(statusDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> statusService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status ANSWER = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Status EXPECTED = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        Mockito.when(statusDAO.save(GIVEN)).thenReturn(ANSWER);
        Status ACTUAL = statusService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(statusDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        Status GIVEN = Status.builder()
                .id(1L)
                .status(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> statusService.update(GIVEN));
    }
}