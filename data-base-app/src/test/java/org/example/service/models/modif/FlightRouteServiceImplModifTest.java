package org.example.service.models.modif;

import org.example.dao.models.FlightRouteDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.AirPlaneService;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.FlightRouteServiceImplModif;
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
class FlightRouteServiceImplModifTest {
    @Mock
    FlightRouteDAO flightRouteDAO;
    @Mock
    AirPlaneService airPlaneService;
    @Mock
    UserOrderService userOrderService;

    @InjectMocks
    FlightRouteServiceImplModif flightRouteServiceImplModif;

    private final Date flightDateStart = new Date(1656846000000L);
    private final Date flightDateEnd = new Date(1656838800000L);

    @Test
    public void whenCreate_thenReturnEntity() {
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> airPlaneList = List.of(airPlane);
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        Mockito.when(flightRouteDAO.save(GIVEN)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart(null)
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        assertThrows(ErrorInvalidData.class, () -> flightRouteServiceImplModif.create(GIVEN));
    }


    @Test
    public void whenUpdate_thenReturnEntityList() {
        AirPlane airPlane = AirPlane.builder()
                .id(1L)
                .type("Boing747")
                .status("Ready to fly")
                .numberSeatLowcost(5)
                .numberSeatBuisness(1)
                .pricePerKilometer(5)
                .isActive(true)
                .build();
        List<AirPlane> airPlaneList = List.of(airPlane);
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        FlightRoute ANSWER = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        FlightRoute EXPECTED = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .airPlaneList(airPlaneList)
                .userOrderList(userOrderList)
                .build();
        Mockito.when(flightRouteDAO.save(GIVEN)).thenReturn(ANSWER);
        FlightRoute ACTUAL = flightRouteServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(flightRouteDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        FlightRoute GIVEN = FlightRoute.builder()
                .id(1L)
                .routeStart(null)
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        assertThrows(ErrorInvalidData.class, () -> flightRouteServiceImplModif.update(GIVEN));
    }
}