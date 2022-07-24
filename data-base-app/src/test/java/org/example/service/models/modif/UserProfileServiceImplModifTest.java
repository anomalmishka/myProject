package org.example.service.models.modif;

import org.example.dao.models.UserProfileDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.*;
import org.example.service.models.api.BankCardService;
import org.example.service.models.api.PassengerProfileService;
import org.example.service.modif.UserProfileServiceImplModif;
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
class UserProfileServiceImplModifTest {
    @Mock
    UserProfileDAO userProfileDAO;
    @Mock
    BankCardService bankCardService;
    @Mock
    PassengerProfileService passengerProfileService;

    @InjectMocks
    UserProfileServiceImplModif userProfileServiceImplModif;

    @Test
    public void whenCreate_thenReturnEntity() {
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> passengerProfileList = List.of(passengerProfile);
        BankCard bankCard = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> bankCardList = List.of(bankCard);
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        UserProfile ACTUAL = userProfileServiceImplModif.create(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenCreate_thenThrowErrorInvalidDataException() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userProfileServiceImplModif.create(GIVEN));
    }

    @Test
    public void whenUpdate_thenReturnEntityList() {
        PassengerProfile passengerProfile = PassengerProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .passportNumber("KK1112223")
                .build();
        List<PassengerProfile> passengerProfileList = List.of(passengerProfile);
        BankCard bankCard = BankCard.builder()
                .id(1L)
                .cardNumber(5555666677778888L)
                .build();
        List<BankCard> bankCardList = List.of(bankCard);
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile ANSWER = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        UserProfile EXPECTED = UserProfile.builder()
                .id(1L)
                .name("Admin")
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .passengerProfileList(passengerProfileList)
                .bankCardList(bankCardList)
                .build();
        Mockito.when(userProfileDAO.save(GIVEN)).thenReturn(ANSWER);
        UserProfile ACTUAL = userProfileServiceImplModif.update(GIVEN);
        assertEquals(EXPECTED, ACTUAL);
        Mockito.verify(userProfileDAO, Mockito.times(1))
                .save(GIVEN);
    }

    @Test
    void whenUpdate_thenThrowErrorInvalidDataException() {
        UserProfile GIVEN = UserProfile.builder()
                .id(1L)
                .name(null)
                .lastname("Admin")
                .phone(5566778)
                .email("admin@gmail.com")
                .isBlockedProfile(false)
                .build();
        assertThrows(ErrorInvalidData.class, () -> userProfileServiceImplModif.update(GIVEN));
    }
}