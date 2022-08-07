package org.example.service.models;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.example.dao.crud.UserProfileDAO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplTest {
    @Mock
    UserProfileDAO userProfileDAO;

    @InjectMocks
    UserProfileServiceImpl userProfileService;

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
    private final PassengerProfile passengerProfile = PassengerProfile.builder()
            .id(1L)
            .passengername("Admin")
            .passengerlastname("Admin")
            .passportNumber("KK1112223")
            .userOrderList(userOrderList)
            .build();
    private final List<PassengerProfile> passengerProfileList = List.of(passengerProfile);
    private final BankCard bankCard = BankCard.builder()
            .id(1L)
            .cardNumber(111122223333444L)
            .build();
    private final List<BankCard> bankCardList = List.of(bankCard);

    @Test
    public void whenCreate_thenReturnEntity() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        UserProfile ACTUAL = userProfileService.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .username(null)
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userProfileService.create(GIVEN));
    }

    @Test
    public void whenReadAll_thenReturnEntityList() {
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> ANSWER_LIST = List.of(ANSWER);
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userProfileDAO.findAll()).thenReturn(ANSWER_LIST);
        List<UserProfile> ACTUAL_LIST = userProfileService.readAll();
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenReadAll_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userProfileDAO.findAll()).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userProfileService.readAll()).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenReadById_thenReturnEntity() {
        Long GIVEN_ID = 1L;
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.ofNullable(ANSWER));
        UserProfile ACTUAL = userProfileService.readById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .findById(GIVEN_ID);
    }

    @Test
    void whenReadById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        Mockito.when(userProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.empty());
        assertThrows(ErrorDataNotFound.class, () -> userProfileService.readById(GIVEN_ID));
    }

    @Test
    public void whenReadAllById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> ANSWER_LIST = List.of(ANSWER);
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userProfileDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        List<UserProfile> ACTUAL_LIST = userProfileService.readAllByIds(GIVEN_ID_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .findAllById(GIVEN_ID_LIST);
    }

    @Test
    void whenReadAllById_thenReturnEntityListSize1() {
        Integer EXPECTED = 1;
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> ANSWER_LIST = List.of(ANSWER);
        Mockito.when(userProfileDAO.findAllById(GIVEN_ID_LIST)).thenReturn(ANSWER_LIST);
        Assertions.assertThat(userProfileService.readAllByIds(GIVEN_ID_LIST)).size().isEqualTo(EXPECTED);
    }

    @Test
    public void whenDeleteById_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.findById(GIVEN_ID)).thenReturn(Optional.of(ANSWER));
        UserProfile ACTUAL = userProfileService.deleteById(GIVEN_ID);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .deleteById(GIVEN_ID);
    }

    @Test
    void whenDeleteById_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        assertThrows(ErrorDataNotFound.class, () -> userProfileService.deleteById(GIVEN_ID));
    }

    @Test
    public void whenDeleteAllByIds_thenReturnEntityList() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> ANSWER_LIST = List.of(ANSWER);
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        List<UserProfile> EXPECTED_LIST = List.of(EXPECTED);
        Mockito.when(userProfileDAO.findAllById(GIVEN_LIST)).thenReturn(ANSWER_LIST);
        Mockito.doNothing().when(userProfileDAO).deleteAllById(GIVEN_LIST);
        List<UserProfile> ACTUAL_LIST = userProfileService.deleteAllByIds(GIVEN_LIST);
        assertEquals(EXPECTED_LIST, ACTUAL_LIST);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .deleteAllById(GIVEN_LIST);
    }

    @Test
    void whenDeleteAllByIds_thenThrowErrorDataNotFoundException() {
        Long GIVEN_ID = 1L;
        List<Long> GIVEN_LIST = List.of(GIVEN_ID);
        Mockito.doThrow(ErrorDataNotFound.class).when(userProfileDAO).deleteAllById(GIVEN_LIST);
        assertThrows(ErrorDataNotFound.class, () -> userProfileService.deleteAllByIds(GIVEN_LIST));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .username("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        UserProfile ACTUAL = userProfileService.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .username(null)
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userProfileService.update(GIVEN));
    }
}