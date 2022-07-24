package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.models.PassengerProfileDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.PassengerProfile;
import org.example.service.models.PassengerProfileServiceImpl;
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
class PassangerProfileServiceImplTest {
    @Mock
    PassengerProfileDAO passengerProfileDAO;

    @InjectMocks
    PassengerProfileServiceImpl passengerProfileService;

    @Test
    public void whenCreate_thenReturnEntity() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Mockito.when(passengerProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        assertThrows(ErrorInvalidData.class, () -> passengerProfileService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileDAO.findAll()).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(passengerProfileDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(passengerProfileService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Mockito.when(passengerProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        PassengerProfile ACTUAL = passengerProfileService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(passengerProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(passengerProfileDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(passengerProfileService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Mockito.when(passengerProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        PassengerProfile ACTUAL = passengerProfileService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(passengerProfileDAO).deleteAllById(GIVEN_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(passengerProfileDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Mockito.when(passengerProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        assertThrows(ErrorInvalidData.class, () -> passengerProfileService.update(GIVEN));
    }
}