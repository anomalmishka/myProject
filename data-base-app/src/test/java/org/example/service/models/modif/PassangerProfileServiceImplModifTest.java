package org.example.service.models.modif;

import org.example.dao.models.PassengerProfileDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.UserOrderService;
import org.example.service.models.api.UserProfileService;
import org.example.service.modif.PassengerProfileServiceImplModif;
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
class PassangerProfileServiceImplModifTest {
    @Mock
    PassengerProfileDAO passengerProfileDAO;
    @Mock
    UserProfileService userProfileService;
    @Mock
    UserOrderService userOrderService;

    @InjectMocks
    PassengerProfileServiceImplModif passengerProfileServiceImplModif;


    @Test
    public void whenCreate_thenReturnEntity() {
        UserProfile userProfile = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .build();
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        assertThrows(ErrorInvalidData.class, () -> passengerProfileServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        UserProfile userProfile = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .build();
        UserOrder userOrder = UserOrder.builder()
                .id(1L)
                .build();
        List<UserOrder> userOrderList = List.of(userOrder);
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        PassengerProfile ANSWER = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        PassengerProfile EXPECTED = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .userProfile(userProfile)
                .userOrderList(userOrderList)
                .build();
        Mockito.when(passengerProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        PassengerProfile ACTUAL = passengerProfileServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(passengerProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        PassengerProfile GIVEN = PassengerProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        assertThrows(ErrorInvalidData.class, () -> passengerProfileServiceImplModif.update(GIVEN));
    }
}