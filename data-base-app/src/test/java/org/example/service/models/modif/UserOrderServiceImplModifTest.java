package org.example.service.models.modif;

import org.example.dao.models.UserOrderDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.PassengerProfile;
import org.example.model.entity.Status;
import org.example.model.entity.UserOrder;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.StatusService;
import org.example.service.modif.UserOrderServiceImplModif;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserOrderServiceImplModifTest {
    @Mock
    UserOrderDAO userOrderDAO;
    @Mock
    FlightRouteService flightRouteService;
    @Mock
    PassengerProfileService passengerProfileService;
    @Mock
    StatusService statusService;

    @InjectMocks
    UserOrderServiceImplModif userOrderServiceImplModif;

    private final Date flightDateStart = new Date(1656846000000L);
    private final Date flightDateEnd = new Date(1656838800000L);

    @Test
    public void whenCreate_thenReturnEntity() {
        FlightRoute flightRoute = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Status status = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        Mockito.when(userOrderDAO.save(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .build();
        assertThrows(NullPointerException.class, () -> userOrderServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        FlightRoute flightRoute = FlightRoute.builder()
                .id(1L)
                .routeStart("Minsk")
                .routeEnd("Moskva")
                .distance(1000)
                .flightDateStart(flightDateStart)
                .flightDateEnd(flightDateEnd)
                .isActive(true)
                .build();
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        Status status = Status.builder()
                .id(1L)
                .status("ORDERED")
                .build();
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .flightRoute(flightRoute)
                .passengerProfile(passengerProfile)
                .status(status)
                .build();
        Mockito.when(userOrderDAO.save(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userOrderServiceImplModif.update(GIVEN));
    }
}