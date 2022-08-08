package org.example.serviceWithDAO;

import lombok.SneakyThrows;
import org.example.model.*;
import org.example.service.filter.api.FilterUserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@AutoConfigureTestDatabase
public class UserProfileServiceDAOTest {

    @Autowired
    FilterUserProfileService filterUserProfileService;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }

    private final Timestamp flightDateStart = new Timestamp(parseStringToLong("2022-09-03 12:00:00"));
    private final Timestamp flightDateEnd = new Timestamp(parseStringToLong("2022-09-03 13:00:00"));

    private final Seat seat = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> seatList = List.of(seat);
    private final AirCompany airCompany = AirCompany.builder()
            .id(1L)
            .nameCompany("Belavia")
            .countryLocation("Minsk")
            .build();
    private final AirPlane airPlane = AirPlane.builder()
            .id(1L)
            .type("Boing747")
            .status("Ready to fly")
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
            .price(200)
            .flightDateStart(flightDateStart)
            .flightDateEnd(flightDateEnd)
            .duration(60)
            .isActive(true)
            .airPlaneFlightRouteList(airPlaneFlightRouteList)
            .build();
    private final Status status = Status.builder()
            .status("PAID_FOR")
            .build();
    private final UserOrder userOrder = UserOrder.builder()
            .id(1L)
            .status(status)
            .flightRoute(flightRoute)
            .build();
    private final List<UserOrder> userOrderList = List.of(userOrder);
    private final PassengerProfile passengerProfile = PassengerProfile.builder()
            .id(1L)
            .passengername("Aleksandr")
            .passengerlastname("Lukashenko")
            .passportNumber("KK1100112")
            .userOrderList(userOrderList)
            .build();
    private final List<PassengerProfile> passengerProfileList = List.of(passengerProfile);
    private final BankCard bankCard = BankCard.builder()
            .id(1L)
            .cardNumber(1111222233334444L)
            .build();
    private final List<BankCard> bankCardList = List.of(bankCard);
    private final UserProfile EXPECTED = UserProfile.builder()
            .id(1L)
            .profilename("Manager")
            .lastname("Manager")
            .phone(998877)
            .email("manager@gmail.com")
            .isBlockedProfile(false)
            .passengerProfileList(passengerProfileList)
            .bankCardList(bankCardList)
            .userId(1L)
            .build();
    @Test
    public void whenUserProfileWhereUserId_thenReturnEntity() {
        Long GIVEN = 1L;
        UserProfile ACTUAL = filterUserProfileService.findWhereUserId(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
    }
}
