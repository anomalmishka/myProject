package org.example.service.models.modif;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.*;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.models.api.UserOrderService;
import org.example.service.modif.PassengerProfileServiceImplModif;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PassangerProfileServiceImplModifTest {

    @Mock
    PassengerProfileService passengerProfileService;
    @Mock
    UserOrderService userOrderService;

    @InjectMocks
    PassengerProfileServiceImplModif passengerProfileServiceImplModif;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }

    private final Timestamp flightDateStart = new Timestamp(parseStringToLong("2022-07-03 12:00:00"));
    private final Timestamp flightDateEnd = new Timestamp(parseStringToLong("2022-07-03 14:00:00"));

    private final Seat seat = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList = List.of(seat);
    private final AirCompany airCompany = AirCompany.builder()
            .id(1L)
            .nameCompany("Aeroflot")
            .countryLocation("Russia")
            .build();
    private final AirPlane airPlane = AirPlane.builder()
            .id(1L)
            .type("747")
            .status("Landing")
            .numberSeatLowcost(5)
            .numberSeatBuisness(1)
            .isActive(true)
            .airCompany(airCompany)
            .seatList(seatList)
            .build();
    private final AirPlaneFlightRoute airPlaneFlightRoute = AirPlaneFlightRoute.builder()
            .id(1L)
            .airPlane(airPlane)
            .build();
    private final List<AirPlaneFlightRoute> airPlaneFlightRouteList = List.of(airPlaneFlightRoute);

    private final FlightRoute flightRoute = FlightRoute.builder()
            .id(1L)
            .routeStart("Minsk")
            .routeEnd("Moskva")
            .distance(1000)
            .flightDateStart(flightDateStart)
            .flightDateEnd(flightDateEnd)
            .isActive(true)
            .airPlaneFlightRouteList(airPlaneFlightRouteList)
            .build();
    private final Status status = Status.builder()
            .status("Paid")
            .build();
    private final UserOrder userOrder = UserOrder.builder()
            .id(1L)
            .status(status)
            .flightRoute(flightRoute)
            .build();
    private final List<UserOrder> userOrderList = List.of(userOrder);

    @Test
    public void whenCreate_thenReturnEntity() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileService.create(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .create(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .passengername(null)
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileService.create(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> passengerProfileServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileService.readAll()).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileServiceImplModif.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .readAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(passengerProfileService.readAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(passengerProfileServiceImplModif.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileService.readById(GIVEN_ID)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(passengerProfileService.readById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileServiceImplModif.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileServiceImplModif.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .readAllByIds(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(passengerProfileService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(passengerProfileServiceImplModif.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileService.deleteById(GIVEN_ID)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(passengerProfileService.deleteById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileServiceImplModif.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> ANSWER_LIST = List.of(ANSWER);
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        List<PassengerProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(passengerProfileService.deleteAllByIds(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        List<PassengerProfile> ACTUAL_LIST = passengerProfileServiceImplModif.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .deleteAllByIds(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(passengerProfileService).deleteAllByIds(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> passengerProfileServiceImplModif.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .passengername("Admin")
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileService.update(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileService, Mockito.times(1))
                .update(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .passengername(null)
                .passengerlastname("Admin")
                .passportNumber("KK1112223")
                .userOrderList(userOrderList)
                .build();
        assertThrows(ErrorInvalidData.class, () -> passengerProfileServiceImplModif.update(GIVEN));
    }
}