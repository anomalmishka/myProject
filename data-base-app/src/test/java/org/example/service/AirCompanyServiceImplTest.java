package org.example.service;

import org.example.dao.models.AirCompanyDAO;
import org.example.model.entity.AirCompany;
import org.example.service.models.AirCompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AirCompanyServiceImplTest {
    @Mock
    AirCompanyDAO airCompanyDAO;

    @InjectMocks
    AirCompanyServiceImpl airCompanyService;

    @Test
    void whenCreate_thenReturnEntity() {
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
    void whenReadAll_thenReturnEntityList() {
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
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        List<AirCompany> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airCompanyDAO.findAll()).thenReturn(ANSWER_LIST);
        List<AirCompany> ACTUAL_LIST = airCompanyService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadById_thenReturnEntity(){
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
    void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
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
        List<AirCompany> ANSWER_LIST = List.of(ANSWER);
        List<AirCompany> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(airCompanyDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<AirCompany> ACTUAL_LIST = airCompanyService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(airCompanyDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenDeleteById_thenReturnEntityList() {
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
//        Mockito.when(airCompanyDAO.deleteById(GIVEN_ID)).thenReturn(ANSWER);
//        List<AirCompany> ACTUAL_LIST = airCompanyService.deleteById(GIVEN_ID);
//        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
//        Mockito.verify(airCompanyDAO, Mockito.times(1))
//                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void deleteAllByIds() {
    }

    @Test
    void update() {
    }
}