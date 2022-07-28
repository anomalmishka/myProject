package org.example.service.models.modif;

import org.example.dao.models.AirPlaneDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.Seat;
import org.example.service.models.api.AirCompanyService;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.SeatService;
import org.example.service.modif.AirPlaneServiceImplModif;
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
class AirPlaneServiceImplModifTest {
    @Mock
    AirPlaneDAO airPlaneDAO;
    @Mock
    AirCompanyService airCompanyService;
    @Mock
    FlightRouteService flightRouteService;
    @Mock
    SeatService seatService;

    @InjectMocks
    AirPlaneServiceImplModif airPlaneServiceImplModif;

    @Test
    public void whenCreate_thenReturnEntity() {
        Date flightDateStart = new Date(1656846000000L);
        Date flightDateEnd = new Date(1656838800000L);
        AirCompany airCompany = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .build();
        FlightRoute flightRoute = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        List<FlightRoute> flightRouteList = List.of(flightRoute);
        Seat seat = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> seatList = List.of(seat);
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        Mockito.when(airPlaneDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.create(GIVEN);
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
        assertThrows(ErrorInvalidData.class, () -> airPlaneServiceImplModif.create(GIVEN));
    }


    @Test
    public void whenUpdate_thenReturnEntityList() {
        Date flightDateStart = new Date(1656846000000L);
        Date flightDateEnd = new Date(1656838800000L);
        AirCompany airCompany = AirCompany.builder()
                .id(1L)
                .nameCompany("Aeroflot")
                .countryLocation("Russia")
                .priceLowcostIndex(1)
                .priceBuisnessIndex(2)
                .build();
        FlightRoute flightRoute = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        List<FlightRoute> flightRouteList = List.of(flightRoute);
        Seat seat = Seat.builder()
                .id(1L)
                .place("1A")
                .type("Lowcost")
                .isOrdered(false)
                .build();
        List<Seat> seatList = List.of(seat);
        AirPlane GIVEN = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        AirPlane ANSWER = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        AirPlane EXPECTED = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
//                .airCompany(airCompany)
                .flightRouteList(flightRouteList)
                .seatList(seatList)
                .build();
        Mockito.when(airPlaneDAO.save(GIVEN)).thenReturn(ANSWER);
        AirPlane ACTUAL = airPlaneServiceImplModif.update(GIVEN);
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
        assertThrows(ErrorInvalidData.class, () -> airPlaneServiceImplModif.update(GIVEN));
    }
}