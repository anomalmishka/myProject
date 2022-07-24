package org.example.service.models.modif;

import org.example.dao.models.AirCompanyDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.service.models.api.AirPlaneService;
import org.example.service.modif.AirCompanyServiceImplModif;
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
class AirCompanyServiceImplModifTest {
    @Mock
    AirCompanyDAO airCompanyDAO;
    @Mock
    AirPlaneService airPlaneService;

    @InjectMocks
    AirCompanyServiceImplModif airCompanyServiceImplModif;

    @Test
    public void whenCreate_thenReturnEntity() {
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .build();
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        Mockito.when(airCompanyDAO.save(GIVEN)).thenReturn(ANSWER);
        AirCompany ACTUAL = airCompanyServiceImplModif.create(GIVEN);
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
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(AirPlane.builder().build()))
                .build();
        assertThrows(ErrorInvalidData.class, () -> airCompanyServiceImplModif.create(GIVEN));
    }


    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .build();
        AirCompany GIVEN = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        AirCompany ANSWER = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        AirCompany EXPECTED = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(airPlane))
                .build();
        Mockito.when(airCompanyDAO.save(GIVEN)).thenReturn(ANSWER);
        AirCompany ACTUAL = airCompanyServiceImplModif.update(GIVEN);
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
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .airPlaneList(List.of(AirPlane.builder().build()))
                .build();
        assertThrows(ErrorInvalidData.class, () -> airCompanyServiceImplModif.update(GIVEN));
    }
}