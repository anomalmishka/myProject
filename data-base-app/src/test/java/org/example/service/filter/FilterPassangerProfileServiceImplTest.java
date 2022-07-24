package org.example.service.filter;

import org.example.dao.custom.passangerProfile.PassengerProfileCustomDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.PassengerProfile;
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
class FilterPassangerProfileServiceImplTest {
    @Mock
    PassengerProfileCustomDAO passengerProfileCustomDAO;

    @InjectMocks
    FilterPassengerProfileServiceImpl filterPassengerProfileService;

    @Test
    public void whereFindAllPassengerProfileWhereAirCompany_thenReturnEntityList() {
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
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileCustomDAO.findAllPassengerProfileWhereAirCompany(GIVEN_ID)).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = filterPassengerProfileService.findAllPassengerProfileWhereAirCompany(GIVEN_ID);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileCustomDAO, Mockito.times(1))
                .findAllPassengerProfileWhereAirCompany(GIVEN_ID);
    }

    @Test
    void whereFindAllPassengerProfileWhereAirCompany_thenThrowErrorInvalidDataException() {
        Long GIVEN_ID = null;
        assertThrows(ErrorInvalidData.class, () -> filterPassengerProfileService.findAllPassengerProfileWhereAirCompany(GIVEN_ID));
    }

    @Test
    public void whereFindAllPassengerProfileWhereAirPlane_thenReturnEntityList() {
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
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileCustomDAO.findAllPassengerProfileWhereAirPlane(GIVEN_ID)).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = filterPassengerProfileService.findAllPassengerProfileWhereAirPlane(GIVEN_ID);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileCustomDAO, Mockito.times(1))
                .findAllPassengerProfileWhereAirPlane(GIVEN_ID);
    }

    @Test
    void whereFindAllPassengerProfileWhereAirPlane_thenThrowErrorInvalidDataException() {
        Long GIVEN_ID = null;
        assertThrows(ErrorInvalidData.class, () -> filterPassengerProfileService.findAllPassengerProfileWhereAirPlane(GIVEN_ID));
    }
}