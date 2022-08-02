package org.example.service.models.modif;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.StatusService;
import org.example.service.models.api.UserOrderService;
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
class UserOrderServiceImplModifTest {

    @Mock
    UserOrderService userOrderService;
    @Mock
    StatusService statusService;
    @Mock
    FlightRouteService flightRouteService;

    @InjectMocks
    UserOrderServiceImplModif userOrderServiceImplModif;

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

    @Test
    public void whenCreate_thenReturnEntity() {
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        Mockito.when(userOrderService.create(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderService, Mockito.times(1))
                .create(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        Mockito.when(userOrderService.create(GIVEN)).thenThrow(ErrorInvalidData.class);
        assertThrows(ErrorInvalidData.class, () -> userOrderServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderService.readAll()).thenReturn(ANSWER_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderServiceImplModif.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderService, Mockito.times(1))
                .readAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userOrderService.readAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userOrderServiceImplModif.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        Mockito.when(userOrderService.readById(GIVEN_ID)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderService, Mockito.times(1))
                .readById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(userOrderService.readById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> userOrderServiceImplModif.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderServiceImplModif.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderService, Mockito.times(1))
                .readAllByIds(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userOrderService.readAllByIds(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userOrderServiceImplModif.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        Mockito.when(userOrderService.deleteById(GIVEN_ID)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderService, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(userOrderService.deleteById(GIVEN_ID)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> userOrderServiceImplModif.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> ANSWER_LIST = List.of(ANSWER);
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        List<UserOrder> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userOrderService.deleteAllByIds(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        List<UserOrder> ACTUAL_LIST = userOrderServiceImplModif.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userOrderService, Mockito.times(1))
                .deleteAllByIds(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.when(userOrderService.deleteAllByIds(GIVEN_LIST)).thenThrow(ErrorDataNotFound.class);
        assertThrows(ErrorDataNotFound.class, () -> userOrderServiceImplModif.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        UserOrder GIVEN = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder ANSWER = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        UserOrder EXPECTED = UserOrder.builder()
                .id(1L)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        Mockito.when(userOrderService.update(GIVEN)).thenReturn(ANSWER);
        UserOrder ACTUAL = userOrderServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userOrderService, Mockito.times(1))
                .update(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        UserOrder GIVEN = UserOrder.builder()
                .id(null)
                .status(status)
                .flightRoute(flightRoute)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userOrderServiceImplModif.update(GIVEN));
    }
}