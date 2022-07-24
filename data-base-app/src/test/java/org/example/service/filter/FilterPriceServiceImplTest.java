package org.example.service.filter;

import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.PriceObj;
import org.example.service.models.api.FlightRouteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FilterPriceServiceImplTest {

    @Mock
    FlightRouteService flightRouteService;

    @InjectMocks
    PriceServiceImpl priceService;


    private final Date flightDateStart = new Date(1656846000000L);
    private final Date flightDateEnd = new Date(1656838800000L);

    @Test
    public void whereGetPriceWhereFlightRoute_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        PriceObj GIVEN = PriceObj.builder()
                .idFlightRoute(GIVEN_ID)
                .build();
        AirCompany airCompany = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .build();
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .airCompany(airCompany)
                .build();
        List<AirPlane> airPlaneList = List.of(airPlane);
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .build();
        PriceObj EXPECTED = PriceObj.builder()
                .idAirCompany(null)
                .idAirPlane(null)
                .idFlightRoute(1L)
                .totalPriceFlyList(List.of(5000))
                .priceLowcostSeat(List.of(833))
                .priceBuisnessSeat(List.of(1666))
                .build();
        Mockito.when(flightRouteService.readById(GIVEN_ID)).thenReturn(ANSWER);
        PriceObj ACTUAL = priceService.getPriceWhereFlightRoute(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whereGetPriceWhereFlightRoute_thenThrowErrorInvalidDataException() {
        Long GIVEN_ID = null;
        PriceObj GIVEN = PriceObj.builder()
                .idFlightRoute(GIVEN_ID)
                .build();
        assertThrows(ErrorInvalidData.class, () -> priceService.getPriceWhereFlightRoute(GIVEN));
    }

}