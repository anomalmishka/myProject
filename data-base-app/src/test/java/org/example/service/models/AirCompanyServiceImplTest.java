package org.example.service.models;

import org.assertj.core.api.Assertions;
import org.example.dao.crud.AirCompanyDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.AirCompany;
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
class AirCompanyServiceImplTest {
    @Mock
    AirCompanyDAO airCompanyDAO;

    @InjectMocks
    AirCompanyServiceImpl airCompanyService;

    @Test
    public void whenCreate_thenReturnEntity() {
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        Mockito.when(airCompanyDAO.save(GIVEN)).thenReturn(ANSWER);
        AirCompany ACTUAL = airCompanyService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany(null)
                .countryLocation("Russia")
                .build();
        assertThrows(ErrorInvalidData.class, () -> airCompanyService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airCompanyDAO.findAll()).thenReturn(ANSWER_LIST);
        List<AirCompany> ACTUAL_LIST = airCompanyService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airCompanyDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airCompanyService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        Mockito.when(airCompanyDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        AirCompany ACTUAL = airCompanyService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(airCompanyDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> airCompanyService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airCompanyDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirCompany> ACTUAL_LIST = airCompanyService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(airCompanyDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(airCompanyService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        Mockito.when(airCompanyDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        AirCompany ACTUAL = airCompanyService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> airCompanyService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        List<AirCompany> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airCompanyDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(airCompanyDAO).deleteAllById(GIVEN_LIST);
        List<AirCompany> ACTUAL_LIST = airCompanyService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(airCompanyDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> airCompanyService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .build();
        Mockito.when(airCompanyDAO.save(GIVEN)).thenReturn(ANSWER);
        AirCompany ACTUAL = airCompanyService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany(null)
                .countryLocation("Russia")
                .build();
        assertThrows(ErrorInvalidData.class, () -> airCompanyService.update(GIVEN));
    }
}